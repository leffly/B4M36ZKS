package moodle.tests;

import moodle.InitTest;
import moodle.model.Assignment;
import moodle.utils.AssignmentsValidator;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class AssignmentsTest extends InitTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/assignments.csv", numLinesToSkip = 1,  delimiter = '\n')
    void createParametrizedAssignmentsTest(String input) {
        String[] inputArray = input.split(",");
        Assignment actualAssignment = new Assignment();
        String expectedResult = inputArray[11];

        Assert.assertTrue(actualAssignment.createAssignment(
                inputArray[0],
                inputArray[1],
                inputArray[2],
                inputArray[3],
                inputArray[4],
                inputArray[5],
                inputArray[6],
                inputArray[7],
                inputArray[8],
                inputArray[9],
                inputArray[10]
        ));

        Assert.assertEquals(expectedResult, AssignmentsValidator.validate(actualAssignment));

    }

}
