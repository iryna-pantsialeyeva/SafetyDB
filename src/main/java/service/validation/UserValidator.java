package service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("([A-Za-z0-9]){3,}@([A-Za-z])+[.]([A-Za-z])+");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isPasswordValid(String email) {
        // TODO: 25.09.2022 add implementation
        return true;
    }
}
