package System.controllers.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException() {
        super(("Record not found"));
    }
}
