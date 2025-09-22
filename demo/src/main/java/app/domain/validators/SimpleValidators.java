package app.domain.validators;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class SimpleValidators {

    public boolean isValidUsername(String username) {
        return Pattern.matches("^[A-Za-z0-9]{1,15}$", username);
    }

    public boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[^A-Za-z0-9]").matcher(password).find();
        return hasUpper && hasDigit && hasSpecial;
    }

    public boolean isValidTelefono(String telefono) {
        return Pattern.matches("^\\d{10}$", telefono);
    }

    public boolean isValidFechaNacimiento(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        if (birthDate.isAfter(today)) {
            return false;
        }
        int edad = Period.between(birthDate, today).getYears();
        return edad <= 150;
    }
}
