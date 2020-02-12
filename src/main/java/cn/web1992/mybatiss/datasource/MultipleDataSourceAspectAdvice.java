package cn.web1992.mybatiss.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据库链接自动切换AOP处理
 * Order优先级设置到最高，因为在所有service方法调用前都必须把数据源确定
 * Order数值越小优先级越高
 */
@Component
@Aspect
@Order(1)
public class MultipleDataSourceAspectAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultipleDataSourceAspectAdvice.class);

    public MultipleDataSourceAspectAdvice() {
        LOGGER.info("MultipleDataSourceAspectAdvice 加载成功");
    }

    /**
     * 定义切面
     */
    @Pointcut("execution(* cn.web1992.mybatiss.service.*..*(..))")
    public void pointCut() {
    }    // dataSourceOneKey    // dataSourceTwoKey    // dataSourceThreeKey

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();

        method = jp.getTarget().getClass()
                .getDeclaredMethod(jp.getSignature().getName(), method.getParameterTypes());
        UseDataSource annotation = method.getAnnotation(UseDataSource.class);
        MultipleDataSource.setDataSourceKey(annotation.value());
        return jp.proceed();
    }

}
