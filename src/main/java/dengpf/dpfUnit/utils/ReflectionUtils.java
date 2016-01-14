package dengpf.dpfUnit.utils;


import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public final class ReflectionUtils {

  public enum MethodSortOrder {
    HierarchyDown, HierarchyUp
  }

  private ReflectionUtils() {
    /* no-op */
  }

  public static ClassLoader getDefaultClassLoader() {
    try {
      return Thread.currentThread().getContextClassLoader();
    } catch (Throwable ex) {
      /* ignore */
    }
    return ClassLoader.getSystemClassLoader();
  }

  public static boolean isPublic(Class<?> clazz) {
    return Modifier.isPublic(clazz.getModifiers());
  }

  public static boolean isPublic(Member member) {
    return Modifier.isPublic(member.getModifiers());
  }


  public static boolean isPrivate(Class<?> clazz) {
    return Modifier.isPrivate(clazz.getModifiers());
  }

  public static boolean isPrivate(Member member) {
    return Modifier.isPrivate(member.getModifiers());
  }

  public static boolean isAbstract(Class<?> clazz) {
    return Modifier.isAbstract(clazz.getModifiers());
  }

  public static boolean isAbstract(Member member) {
    return Modifier.isAbstract(member.getModifiers());
  }

  public static boolean isStatic(Class<?> clazz) {
    return Modifier.isStatic(clazz.getModifiers());
  }

  public static boolean isStatic(Member member) {
    return Modifier.isStatic(member.getModifiers());
  }

}
