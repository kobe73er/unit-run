package dengpf.dpfUnit.model;

import java.lang.reflect.InvocationTargetException;

import dengpf.dpfUnit.annotation.Test;


public interface IMyTest {

  boolean isAnnotationPresent(Class<Test> class1);

  public void invoke(Object newInstance) throws IllegalAccessException, IllegalArgumentException,
      InvocationTargetException;

}
