Feature: User Login

  @signup
  Scenario Outline: Register a new user
    Given the user is on LoginPage "<url>"
    When the user clicks on login
    When enters a unique email "<email>" and password "<Password>"
    And clicks the login button
    And error message is generated
   

  Examples:
    | url                                 | email                    | Password      |
    | https://demowebshop.tricentis.com/  | Yogeswari123@gmail.com   | Yogeswari22 |


    