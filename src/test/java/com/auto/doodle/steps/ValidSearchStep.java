// File: google/src/test/java/com/auto/doodle/steps/ValidSearchStep.java
package com.auto.doodle.steps;

import com.auto.doodle.pages.ValidSearchPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;

public class ValidSearchStep {

    private WebDriver driver;
    private WebDriverWait wait;
    private ValidSearchPage searchPage;
    private Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); 
        driver.manage().window().maximize();
        searchPage = new ValidSearchPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    } 

    private void attachScreenshot(String name) {
        if (driver != null && scenario != null) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", name);
        }
    }

    @Given("I am on the Doodle search page")
    public void i_am_on_the_doodle_search_page() {
        driver.manage().deleteAllCookies();
        searchPage.openSearchPage();
    }

    @When("I select the color\\(s) {string} from the colors tab")
    public void i_select_the_color_s_from_the_colors_tab(String string) {
        searchPage.clickMainSearchButton();
        searchPage.clickColorsTab();
        searchPage.selectColor(string);
    }

    @When("I select the topic {string} from the Topics tab")
    public void i_select_the_topic_from_the_topics_tab(String topic) {
        searchPage.clickMainSearchButton();
        driver.manage().deleteAllCookies();
        searchPage.clickTopicsTab();
        searchPage.selecttopics();
    }

    @When("I enter {string} in the search bar")
    public void i_enter_in_the_search_bar(String keyword) {
        searchPage.clickMainSearchButton();
        driver.manage().deleteAllCookies();
        searchPage.SupriseClick();
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        driver.manage().deleteAllCookies();
        searchPage.clickColorSearchButton();
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
    }

    @When("I click on the tab")
    public void i_click_on_the_tab() {
        searchPage.SupriseClick();
    }

    @Then("the first scenario image should be displayed")
    public void the_first_scenario_image_should_be_displayed() {
        System.out.println("Swedan");
    }

    @Then("the second scenario image should be displayed")
    public void the_second_scenario_image_should_be_displayed() {
        System.out.println("Swedacv");
        waitForDoodleImageToLoadAndScreenshot();
        attachScreenshot("second scenario image");
    }

    @Then("the first doodle title should be {string}")
    public void the_first_doodle_title_should_be(String expectedTitle) {
        waitForDoodleImageToLoadAndScreenshot();
        attachScreenshot("first doodle title");
    }

    @Then("the third scenario image should be displayed")
    public void the_third_scenario_image_should_be_displayed() {
        System.out.println("Swedan");
        waitForDoodleImageToLoadAndScreenshot();
        attachScreenshot("third scenario image");
    }

    @Then("the first doodle title should be related to {string}")
    public void the_first_doodle_title_should_be_related_to(String keyword) {
        System.out.println("9878");
        waitForDoodleImageToLoadAndScreenshot();
        attachScreenshot("first doodle title related to keyword");
    }

    @Then("I attach a screenshot of the doodle to the extent report")
    public void i_attach_a_screenshot_of_the_doodle_to_the_extent_report() {
        waitForDoodleImageToLoadAndScreenshot();
        attachScreenshot("doodle screenshot");
    }

    // Helper method to wait for the doodle image to load dynamically
 // java
    private void waitForDoodleImageToLoadAndScreenshot() {
        By doodleImageSelector = By.cssSelector("img[src*='/logos/doodles/']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(doodleImageSelector));
            wait.until(d -> {
                String src = imageElement.getAttribute("src");
                return src != null && !src.isEmpty();
            });
            attachScreenshot("doodle screenshot");
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Doodle image not found or did not load in time.");
            attachScreenshot("doodle image not found");
        }
    }


}

