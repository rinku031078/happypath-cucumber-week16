package com.jotform.pages;

import com.jotform.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmissionPage extends Utility {

    private static final Logger log = LogManager.getLogger(SubmissionPage.class.getName());
    public SubmissionPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//h1[contains(text(),'Thank You!')]")
    WebElement thankYouMessage;

    @CacheLookup
    @FindBy (xpath = "//div[contains(text(),'Your submission has been received!')]")
    WebElement submissionMessage;

    public void verifyFormSubmission(String message){
        log.info("Verifying 'Thank You!' message " + thankYouMessage.toString());
        doVerifyElements(thankYouMessage,"Thank You!", "Thank You!");
        log.info("Verifying form submission message " + submissionMessage.toString());
        verifyThatTextIsDisplayed(submissionMessage, message);
    }


}
