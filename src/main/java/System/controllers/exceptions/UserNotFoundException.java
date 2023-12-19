package System.controllers.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id) {
        super(("Could not login user with id " + id));
    }
}
