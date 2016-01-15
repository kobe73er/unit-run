/**
 * 
 */
package com.dengpf.unitrun.model;

import java.lang.reflect.Method;

/**
 * @author kobe73er
 *
 */
public class FrameworkMethod extends FrameworkMember {


  protected Method method;
  protected String name;
  protected String id;
  protected boolean isEnabled;
  protected long timeout;
  protected int order;

  protected Throwable throwAble;

  public Throwable getThrowAble() {
    return throwAble;
  }

  public void setThrowAble(Throwable throwAble) {
    this.throwAble = throwAble;
  }

  public Method getMethod() {
    return method;
  }

  public void setMethod(Method method) {
    this.method = method;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public long getTimeout() {
    return timeout;
  }

  public void setTimeout(long timeout) {
    this.timeout = timeout;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }



}
