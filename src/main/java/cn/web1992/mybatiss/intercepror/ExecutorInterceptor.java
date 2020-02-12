/**
 *    Copyright 2010-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package cn.web1992.mybatiss.intercepror;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * Keeps track of Executor commits, rollbacks and close status.
 *
 * The Executor is not accessible from DefaultSqlSession, so it is much easier to use an Interceptor
 * rather than subclass a new SqlSessionFactory, etc. Also, there is the potential to change the
 * default MyBatis behavior, which could change the test results.
 * @author web1992
 */
@Intercepts({
    @Signature(type = Executor.class, method = "update", args = { MappedStatement.class ,Object.class}),
    @Signature(type = Executor.class, method = "commit", args = { boolean.class }),
    @Signature(type = Executor.class, method = "rollback", args = { boolean.class }),
    @Signature(type = Executor.class, method = "close", args = { boolean.class })
})
public class ExecutorInterceptor implements Interceptor {
  public ExecutorInterceptor() {
  }

  private int commitCount;

  private int rollbackCount;

  private boolean closed;

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    if ("commit".equals(invocation.getMethod().getName())) {
      ++this.commitCount;
    } else if ("rollback".equals(invocation.getMethod().getName())) {
      ++this.rollbackCount;
    } else if ("close".equals(invocation.getMethod().getName())) {
      this.closed = true;
    }

    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    // do nothing
  }

  void reset() {
    this.commitCount = 0;
    this.rollbackCount = 0;
    this.closed = false;
  }

  int getCommitCount() {
    return this.commitCount;
  }

  int getRollbackCount() {
    return this.rollbackCount;
  }

  boolean isExecutorClosed() {
    return this.closed;
  }

}
