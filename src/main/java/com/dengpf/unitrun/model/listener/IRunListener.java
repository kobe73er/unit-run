/**
 * 
 */
package com.dengpf.unitrun.model.listener;

import com.dengpf.unitrun.model.FTest;
import com.dengpf.unitrun.model.IMyTest;

/**
 * @author kobe73er
 *
 */
public interface IRunListener {
  public abstract void runStart(IMyTest mytestItem);

  public abstract void runFinish(IMyTest mytestItem);

  public abstract void runAbort(FTest mytestItem, Exception ex);
}
