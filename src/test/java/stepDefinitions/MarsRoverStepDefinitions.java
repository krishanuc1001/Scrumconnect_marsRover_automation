package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marsrover.Rover;
import org.testng.asserts.SoftAssert;

public class MarsRoverStepDefinitions {
    private Rover rover;

    @Given("a plateau with upper-right coordinates {string}")
    public void aPlateauWithUpperRightCoordinates(String coordinates) {
        // Extract and set the upper-right coordinates of the plateau
        String[] coords = coordinates.split(" ");
        int upperRightX = Integer.parseInt(coords[0]);
        int upperRightY = Integer.parseInt(coords[1]);
        rover = new Rover(upperRightX, upperRightY);
    }

    @Given("a rover positioned at {string}")
    public void aRoverPositionedAt(String position) {
        // Extract and set the rover's position and direction
        String[] parts = position.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        String direction = parts[2];
        rover.setPosition(x, y, Integer.valueOf(direction));
    }

    @When("I initialize the rover")
    public void iInitializeTheRover() {
        // Perform any necessary initialization logic
    }

    @When("I send the rover the command {string}")
    public void iSendTheRoverTheCommand(String command) {
        rover.process(command);
    }

    @Then("the rover's position should be {string}")
    public void theRoverPositionShouldBe(String expectedPosition) {
        String[] parts = expectedPosition.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        String direction = parts[2];

        // Get the current position and direction of the rover
        int actualX = rover.getX();
        int actualY = rover.getY();
        String actualDirection = rover.getDirection();

        // Verify the position and direction of the rover
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(x, actualX);
        softAssert.assertEquals(y, actualY);
        softAssert.assertEquals(direction, actualDirection);
    }

    @Then("the rover's direction should be {string}")
    public void theRoverSDirectionShouldBe(String arg0) {
    }

    @Then("the rovers direction should be {string}")
    public void theRoversDirectionShouldBe(String arg0) {
    }

    @Then("the rovers position should be {string}")
    public void theRoversPositionShouldBe(String arg0) {
    }
}
