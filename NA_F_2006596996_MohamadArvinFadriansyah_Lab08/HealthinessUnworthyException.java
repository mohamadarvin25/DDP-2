import java.io.IOException;

// Kelas custom exception pasti turunan dari kelas exception
public class HealthinessUnworthyException extends IOException {

    public HealthinessUnworthyException(String errorMessage) {

        // Implementasi agar dapat menggunakan syntax exception
        super(errorMessage);
    }
}
