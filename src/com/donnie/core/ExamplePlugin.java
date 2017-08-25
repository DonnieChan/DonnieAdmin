package com.donnie.core;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

//@Intercepts({ @Signature(type = Executor.class, method = "update", args = {
//MappedStatement.class, Object.class }) })
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }),
    @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class })
    })
public class ExamplePlugin implements Interceptor {
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("=================="+invocation);
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		System.out.println(target);
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}