package MiniProject;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchForSchools {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "https://www.eduvidya.com/";

    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
           
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
           
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser");
        }
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void searchSchools(Map<String, String> testData) {
        try {
            driver.get(baseUrl);
            wait.until(ExpectedConditions.titleContains("Eduvidya"));

            
            WebElement schoolLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Schools')]")));
            schoolLink.click();

            
            WebElement course = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddl_Category")));
            Select courseSelect = new Select(course);
            courseSelect.selectByVisibleText(testData.get("CourseType"));

           
            WebElement city = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddl_City")));
            Select citySelect = new Select(city);
            citySelect.selectByVisibleText(testData.get("City"));

            
            WebElement searchBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("ctl00$cp_left$btnSearch")));
            searchBtn.click();

            
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("filter-result")));
            System.out.println("Test Completed successfully - " + testData.get("CourseType") + 
                               " schools in " + testData.get("City") + " are displayed happily!!");

        } catch (Exception e) {
            System.out.println("Test failed with exception:  " + e.getMessage()+"Want check again babs!!");
            throw e;
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void main(String[] args) {
        SearchForSchools schoolSearch = new SearchForSchools();
        schoolSearch.setup("chrome");
        
        try {
            Map<String, String> testData = new HashMap<>();
            testData.put("CourseType", "CBSE");
            testData.put("City", "Pune");
            
            schoolSearch.searchSchools(testData);
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
}




//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
