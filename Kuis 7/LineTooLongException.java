import java.io.IOException;

public class LineTooLongException extends IOException {

    public LineTooLongException(String errorMessage) {
        super(errorMessage);
    }

}