package cn.web1992.mybatiss.intercepror;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author web1992
 * @date 2020/2/12  19:49
 */
@Intercepts({
        @Signature(type = ParameterHandler.class, method = "getParameterObject", args = {}),
        @Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class})
})
public class ParameterHandlerInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(ParameterHandlerInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 需要在指定的 plugin 中 进行设置 property
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        //  key b value is 2
        logger.info(" key b value is " + properties.getProperty("b"));
    }
}
