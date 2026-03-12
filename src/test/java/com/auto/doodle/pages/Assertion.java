package com.auto.doodle.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Assertion {
    private WebDriver driver;

    public Assertion(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    @FindBy(xpath = "//img[@alt='Sweden National Day 2025']")
    public WebElement firstScenarioImage;

    @FindBy(xpath = "//img[@alt=\"Kamn Ismail 's 67th Birthday\"]")
    public WebElement secondScenarioImage;

    @FindBy(xpath = "//img[@alt='Tanabata 2025']")
    public WebElement thirdScenarioImage;

    public void assertFirstScenarioImagePresent() {
        if (firstScenarioImage == null || !firstScenarioImage.isDisplayed()) {
            throw new AssertionError("First scenario image not displayed");
        }
    }

    public void assertSecondScenarioImagePresent() {
        if (secondScenarioImage == null || !secondScenarioImage.isDisplayed()) {
            throw new AssertionError("Second scenario image not displayed");
        }
    }

    public void assertThirdScenarioImagePresent() {
        if (thirdScenarioImage == null || !thirdScenarioImage.isDisplayed()) {
            throw new AssertionError("Third scenario image not displayed");
        }
    }

    public void takeScreenshot(String filePath) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File(filePath));
    }
}
