package app.adapters.validators;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class SimpleValidators {

    public static final Pattern SIMPLE_EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]{2,}$");

    public boolean isValidUsername(String username) {
        if (username == null) return false;
        String t = username.trim();
        return !t.isEmpty() && Pattern.matches("^[A-Za-z0-9]{1,15}$", t);
    }
    
    public boolean isValidPassword(String password) {
        if (password == null) return false;
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*[a-z].*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        if (!password.matches(".*[^A-Za-z0-9].*")) return false;
        return true;
    }

    public boolean isValidPhone(String phone) {
        if (phone == null) return false;
        String digits = phone.replaceAll("\\D", "");
        return digits.length() >= 7 && digits.length() <= 15;
    }

    public boolean isValidTelefono(String telefono) {
        return isValidPhone(telefono);
    }

    public boolean isValidBirthDate(LocalDate birthDate) {
        if (birthDate == null) return false;
        LocalDate today = LocalDate.now();
        if (birthDate.isAfter(today)) return false;
        int age = Period.between(birthDate, today).getYears();
        return age >= 0 && age <= 150;
    }

    public boolean isValidFechaNacimiento(LocalDate fechaNacimiento) {
        return isValidBirthDate(fechaNacimiento);
    }

    public boolean isValidEmail(String email) {
        if (email == null) return false;
        String trimmed = email.trim();
        if (trimmed.isEmpty()) return false;
        return SIMPLE_EMAIL.matcher(trimmed).matches();
    }

    public boolean isLessThan30(String value) {
        if (value == null) return false;
        String t = value.trim();
        if (t.isEmpty()) return false;
        return t.length() < 30;
    }

    public boolean isValidAddress(String address) {
        if (address == null) return false;
        return address.trim().length() <= 30;
    }
}
