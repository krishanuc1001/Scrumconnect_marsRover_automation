package functionalTests;

import marsrover.Rover;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import stepDefinitions.MarsRoverStepDefinitions;

public class RoverFunctionalTest {

    private final Rover rover = new Rover();

    @Test
    public void verifyPositionAndDirectionOfRover() {
        // Expected position and direction of the rover
        int x = 1;
        int y = 2;
        String direction = "N";
        new MarsRoverStepDefinitions().theRoverPositionShouldBe(x + " " + y + " " + direction);

        // Current position and direction of the rover
        int actualX = rover.getX();
        int actualY = rover.getY();
        String actualDirection = rover.getDirection();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(x, actualX);
        softAssert.assertEquals(y, actualY);
        softAssert.assertEquals(direction, actualDirection);

        softAssert.assertAll();
    }

}
