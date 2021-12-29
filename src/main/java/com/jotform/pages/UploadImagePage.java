package com.jotform.pages;

import com.jotform.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadImagePage extends Utility {

    private static final Logger log = LogManager.getLogger(UploadImagePage.class.getName());
    public UploadImagePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//button[@class='jfInput-button forSubmit form-submit-button u-right']")
    WebElement submitButton;

    public void clickOnSubmitButton() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Clicking on Submit button " + submitButton.toString());
        doClickOnElement(submitButton);
    }

}
