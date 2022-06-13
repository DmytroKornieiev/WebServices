Feature: As a user i want to login on site

  @Positive
  Scenario Outline: I can login to the site
    Given I open Homepage
    When I enter a "<login>" and "<password>"
    And Click to login button
    Then Page with "<url>" is opened

    Examples:
      | login             | password     | url                                      |
      | standard_user     | secret_sauce | https://www.saucedemo.com/inventory.html |

  @Negative
  Scenario Outline: I can't login to the site
    Given I open Homepage
    When I enter a "<login>" and "<password>"
    And Click to login button
    Then Url is not change

    Examples:
      | login             | password |
      | standard_user     | secret   |

  @Smoke
  Scenario: I can see error
    Given I open Homepage
    When All fields is empty
    And Click to login button
    Then I can see error message
