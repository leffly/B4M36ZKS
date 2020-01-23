package moodle.utils;

import moodle.model.Assignment;

public class AssignmentsValidator {

    public static String validate(Assignment assignment){
        if(!isBasicStringValid(assignment.getName())) return ExpectedResultEnum.FAIL.toString();
        if(assignment.getSubmissionDateYear() > assignment.getDueDateYear()) return ExpectedResultEnum.FAIL.toString();
        return ExpectedResultEnum.PASS.toString();
    }

    private static boolean isBasicStringValid(String input){
        if(input == null || input.isEmpty()) return false;
        return true;
    }

}
