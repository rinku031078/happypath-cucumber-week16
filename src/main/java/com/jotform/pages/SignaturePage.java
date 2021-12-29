package com.jotform.pages;

import com.jotform.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignaturePage extends Utility {

    private static final Logger log = LogManager.getLogger(SignaturePage.class.getName());
    public SignaturePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "(//button[contains(@class,'jfInput-button forNext')])[3]")
    WebElement nextButton;

    @CacheLookup
    @FindBy (tagName = "canvas")
    WebElement canvas;


    public void drawSignature() throws InterruptedException {

        doClickOnElement(canvas);
        log.info("Clicking into canvas to draw signature " + canvas.toString());
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(canvas)
                .clickAndHold()
                .moveToElement(canvas,20,20)
                .release(canvas)
                .clickAndHold()
                .moveByOffset(-50, 60)
                .moveByOffset(-60, -70)
                .moveByOffset(150, 60)
                .moveByOffset(-60, -70)
                .doubleClick()
                .build();
        drawAction.perform();

        Thread.sleep(5000);
        log.info("Clicking on next button " + nextButton.toString());
        doClickOnElement(nextButton);
    }

    public void clickOnNextButton(){
        doClickOnElement(nextButton);
    }

}
