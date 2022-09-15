
  Feature: BBC login feature

    @bbcLogin
    Scenario: user should login with credentials
      Given user navigates to BBC website
      When user enter correct credentials
      Then user should see home page
      And user clicks on news button

