package com.auto.doodle.pages;
 
import java.time.Duration;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class ValidSearchPage {
 
    private WebDriver driver;
    private WebDriverWait wait;
 
    public ValidSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
 
    // WebElements
    @FindBy(xpath = "//a[@data-g-template_id='header_search']//*[name()='svg']")
    private WebElement mainSearchButton;
    
    @FindBy(xpath = "//span[@id='search-doodle__filter-5-toggle']")
    private WebElement colorsTab;
 
    @FindBy(xpath = "//span[contains(text(),'Blue')]")
    private WebElement colorBlue;
 
    @FindBy(xpath = "//body/div[@id='content']/div[@class='main-page']/div[@class='search-doodle']/div[@class='search-doodle__filter doodle-module']/div[@class='search-doodle__filter_mobile-wrapper glue-expansion-panels glue-page']/div[@class='search-doodle__filter_mobile-panel search-doodle__filter-panel']/div[@class='search-doodle__filter_mobile-panel__content glue-expansion-panel__content tabs-container']/form[@class='search-doodle__filter-form']/div[@class='glue-expansion-panels search-doodle__filter-wrapper glue-is-mixed']/div[@class='search-doodle__filter-panel glue-expansion-panel glue-is-expanded']/div[@id='search-doodle__filter-5-content']/div[@class='glue-page']/div[@class='search-doodle__filter-panel__content-circle']/label[6]/div[1]/div[1]")
    private WebElement colorGreen;
 
    @FindBy(xpath = "//span[@class='search-doodle__box-button_search-input']")
    private WebElement colorSearchButton;
 
    @FindBy(css = ".doodle-title")
    private WebElement firstDoodleTitle;
 
    @FindBy(css = ".doodle-image")
    private WebElement firstDoodleImage;
 
    @FindBy(xpath = "//span[contains(text(),'Topic')]")
    private WebElement topicsTab;
    
    @FindBy(xpath = "//div[@class='search-doodle__filter-panel__content-topics']//div[1]//div[2]//label[1]//div[2]")
    private WebElement selecttopics;
 
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBar;
    
    @FindBy(xpath = "//button[@name='random']")
    private WebElement randomsearch;
    
 
    // Example: Add more topic elements as needed
    @FindBy(xpath = "//span[contains(text(),'Science')]")
    private WebElement topicScience;
 
    //=============================================== Methods
 
    public void openSearchPage() {
    	driver.get("https://doodles.google/");
        wait.until(ExpectedConditions.visibilityOf(mainSearchButton));
    }
 
    public void clickMainSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(mainSearchButton));
        mainSearchButton.click();
    }
 
    public void clickColorsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(colorsTab));
        colorsTab.click();
    }
 
    public void selectColor(String color) {
        switch (color.toLowerCase()) {
            case "blue":
                wait.until(ExpectedConditions.elementToBeClickable(colorBlue));
                colorBlue.click();
                break;
            case "green":
                wait.until(ExpectedConditions.elementToBeClickable(colorGreen));
                colorGreen.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported color: " + color);
        }
    }
 
    public void clickColorSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(colorSearchButton));
        colorSearchButton.click();
    }
 
    public void clickTopicsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(topicsTab));
        topicsTab.click();
    }
    
    public void selecttopics() {
    	wait.until(ExpectedConditions.elementToBeClickable(selecttopics));
    	selecttopics.click();
    }
 
//    public void selectTopic(String topic) {
//        switch (topic.toLowerCase()) {
//            case "science":
//                wait.until(ExpectedConditions.elementToBeClickable(topicScience));
//                topicScience.click();
//                break;
//            // Add more cases for other topics as needed
//            default:
//                throw new IllegalArgumentException("Unsupported topic: " + topic);
//        }
//    }
 
    public void enterKeywordInSearchBar(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.clear();
        searchBar.sendKeys(keyword);
    }
 
    public String getFirstDoodleTitle() {
        wait.until(ExpectedConditions.visibilityOf(firstDoodleTitle));
        return firstDoodleTitle.getText();
    }
 
    public WebElement getFirstDoodleImage() {
        wait.until(ExpectedConditions.visibilityOf(firstDoodleImage));
        return firstDoodleImage;
    }
    
    public void SupriseClick() {
    	randomsearch.click();
//    	wait.until(ExpectedConditions.visibilityOf(randomsearch));
//    	randomsearch.sendKeys("Music");
    }
}
 
 