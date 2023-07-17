package UnitTests;

import marsrover.Rover;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RoverTest {

    @Test
    public void testRoverPositionInitialization() {
        Rover rover = new Rover();
        rover.setPosition(1, 2, Rover.N);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(rover.x.intValue(), 1);
        softAssert.assertEquals(rover.y.intValue(), 2);
        softAssert.assertEquals(rover.facing, Rover.N);
        softAssert.assertAll();
    }

    @Test
    public void testRoverMovement() {
        SoftAssert softAssert = new SoftAssert();
        Rover rover = new Rover();
        rover.setPosition(1, 2, Rover.N);

        rover.move();
        softAssert.assertEquals(rover.y.intValue(), 3);

        rover.turnLeft();
        rover.move();
        softAssert.assertEquals(rover.x.intValue(), 0);

        rover.turnLeft();
        rover.move();
        softAssert.assertEquals(rover.y.intValue(), 2);

        rover.turnLeft();
        rover.move();
        softAssert.assertEquals(rover.x.intValue(), 1);
        softAssert.assertAll();
    }

    @Test
    public void testRoverScenario() {
        Rover rover = new Rover();
        rover.setPosition(1, 2, Rover.N);
        rover.process("LMLMLMLMM");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rover.x.intValue(), 1);
        softAssert.assertEquals(rover.y.intValue(), 3);
        softAssert.assertEquals(rover.facing, Rover.N);
        softAssert.assertAll();
    }
}