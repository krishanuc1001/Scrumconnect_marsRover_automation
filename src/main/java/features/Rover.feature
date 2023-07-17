Feature: Mars Rovers
  As a NASA engineer
  I want to control rovers on Mars
  So that I can explore the Martian terrain

  Scenario: Initialize Rover Position and Direction
    Given a plateau with upper-right coordinates "5 5"
    And a rover positioned at "1 2 N"
    When I initialize the rover
    Then the rover's position should be "1 2 N"

  Scenario: Move Rover and Update Position
    Given a rover positioned at "1 2 N"
    When I send the rover the command "M"
    Then the rover's position should be "1 3 N"

  Scenario: Rotate Rover Left and Update Direction
    Given a rover positioned at "1 2 N"
    When I send the rover the command "L"
    Then the rover's direction should be "W"

  Scenario: Rotate Rover Right and Update Direction
    Given a rover positioned at "1 2 N"
    When I send the rover the command "R"
    Then the rovers direction should be "E"

  Scenario: Move Rover as per Problem Scenario
    Given a plateau with upper-right coordinates "5 5"
    And a rover positioned at "1 2 N"
    When I send the rover the command "LMLMLMLMM"
    Then the rovers position should be "1 3 N"

  Scenario: Move Another Rover as per Problem Scenario
    Given a plateau with upper-right coordinates "5 5"
    And a rover positioned at "3 3 E"
    When I send the rover the command "MMRMMRMRRM"
    Then the rovers position should be "5 1 E"
