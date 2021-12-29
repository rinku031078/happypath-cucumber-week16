Feature: Happy Path

  Background: I am on homepage

    Scenario: Verify user should able to submit form
      When  I click on 'START' button
      And   I enter 'First Name' and 'Last Name'
      And   I upload file
      And   I draw signature
      And   I select date
      And   I answer a security question
      And   I submit form
      Then  I am able to submit form successfully
