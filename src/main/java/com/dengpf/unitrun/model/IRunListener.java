/**
 * 
 */
package com.dengpf.unitrun.model;

/**
 * @author kobe73er
 *
 */
public interface IRunListener {
  public abstract void runStart();

  public abstract void runFinish();

  public abstract void exceptionHappen();
}
