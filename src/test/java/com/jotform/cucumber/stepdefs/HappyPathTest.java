package com.jotform.cucumber.stepdefs;

import com.jotform.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;

public class HappyPathTest {

    @When("^I click on 'START' button$")
    public void iClickOnSTARTButton() {
        new HomePage().clickOnStartButton();
    }

    @And("^I enter 'First Name' and 'Last Name'$")
    public void iEnterFirstNameAndLastName() throws InterruptedException {
        new PersonalDetailsPage().enterFirstNameAndLastName("Harry", "Potter");
    }

    @And("^I upload file$")
    public void iUploadFile() throws InterruptedException, AWTException {
        new UploadFilePage().uploadFile();
    }

    @And("^I draw signature$")
    public void iDrawSignature() throws InterruptedException {
        new SignaturePage().drawSignature();
    }

    @And("^I select date$")
    public void iSelectDate() throws InterruptedException {
        new CalanderPage().selectDate();
    }

    @And("^I answer a security question$")
    public void iAnswerASecurityQuestion() throws InterruptedException {
        new SecurityQuestions().selectSecurityQuestion("Hilltop School");
    }

    @And("^I submit form$")
    public void iSubmitForm() throws InterruptedException {
        new UploadImagePage().clickOnSubmitButton();
    }

    @Then("^I am able to submit form successfully$")
    public void iAmAbleToSubmitFormSuccessfully() {
        new SubmissionPage().verifyFormSubmission("Your submission has been received!");
    }
}
