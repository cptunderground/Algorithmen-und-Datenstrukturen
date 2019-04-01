package exercise12.utils;

public class NotImplementedException extends RuntimeException {

    public NotImplementedException(String clazz, String method) {
        super("Method not yet implemented " + clazz + "." + method);
    }
}
