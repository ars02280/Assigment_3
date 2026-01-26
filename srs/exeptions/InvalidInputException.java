public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String msg) {
        super(msg);
    }
}

public class DuplicateResourceException
        extends InvalidInputException {
    public DuplicateResourceException(String msg) {
        super(msg);
    }
}
public class ResourceNotFoundException extends RuntimeException {}
public class DatabaseOperationException extends RuntimeException {}
