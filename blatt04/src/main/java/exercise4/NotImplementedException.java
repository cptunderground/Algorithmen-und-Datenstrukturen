package exercise4;

public class NotImplementedException extends RuntimeException {

  public NotImplementedException(String method) {
    super("You have not yet implemented the method " + method);
  }
}
