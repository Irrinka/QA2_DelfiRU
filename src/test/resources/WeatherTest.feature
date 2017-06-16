Feature: This is test suit for weather service
  Scenario: Test LON and LAT values
    When we are requesting weather info
    Then LON should be -0.13
    And LAT should be 51.51