Feature: User Login

  @signup
  Scenario Outline: Register a new user
    Given the user is on LoginPage "<url>"
    When the user clicks on login
    When enters a unique email "<email>" and password "<Password>"
    And clicks the login button
   

  Examples:
    | url                                 | email                    | Password      |
    | https://demowebshop.tricentis.com/  | yogitha22@gmail.com   | fW3D@QH3rtYbts  |


    