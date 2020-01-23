package moodle.utils;

import moodle.model.User;

public class UserCreationValidator {

    public static String validate(User user){
        if(!isEmailValid(user.getEmail())) return ExpectedResultEnum.FAIL.toString();
        if(!isBasicStringValid(user.getFirstName())) return ExpectedResultEnum.FAIL.toString();
        if(!isBasicStringValid(user.getPassword())) return ExpectedResultEnum.FAIL.toString();
        if(!isBasicStringValid(user.getSurname())) return ExpectedResultEnum.FAIL.toString();
        if(!isBasicStringValid(user.getUsername())) return ExpectedResultEnum.FAIL.toString();
        return ExpectedResultEnum.PASS.toString();
    }

    private static boolean isEmailValid(String email){
        if(email == null || email.isEmpty()) return false;
        String[] splitByAt = email.split("@");
        if(splitByAt.length != 2) return false;
        String[] splitByDot = splitByAt[1].split("\\.");
        if(splitByDot.length != 2) return false;
        return true;
    }

    private static boolean isBasicStringValid(String input){
        if(input == null || input.isEmpty()) return false;
        return true;
    }

}
