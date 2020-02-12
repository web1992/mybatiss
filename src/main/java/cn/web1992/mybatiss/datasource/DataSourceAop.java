package cn.web1992.mybatiss.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author web1992
 * Order(-1) 优先级越小的，越先执行
 */
@Aspect
@Component
@Order(-1)
public class DataSourceAop {
    @Before("execution(* cn.web1992.mybatiss.service.*..*(..))")
    public void setDataSource(JoinPoint jp) throws NoSuchMethodException {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();

        method = jp.getTarget().getClass()
                .getDeclaredMethod(jp.getSignature().getName(), method.getParameterTypes());
        UseDataSource annotation = method.getAnnotation(UseDataSource.class);
        if (null != annotation) {
            MultipleDataSource.setDataSourceKey(annotation.value());
        }
    }


}
