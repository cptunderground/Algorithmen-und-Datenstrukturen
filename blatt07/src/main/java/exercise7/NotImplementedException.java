package exercise7;

public class NotImplementedException extends RuntimeException {

  public NotImplementedException(String clazz, String method) {
    super("Method not implemented" + clazz + "::" + method);
  }
}
