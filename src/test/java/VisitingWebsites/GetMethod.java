package VisitingWebsites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GetMethod {

    public static void main (String [] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("file://C:\\Users\\WAE021\\IdeaProjects\\Selenium_QACart\\src\\test\\resources\\index.html");
       String url= driver.getCurrentUrl();
       System.out.println("The current URL is "+url);
       String title = driver.getTitle();
       System.out.println("The current title is "+title);
       String elementText = driver.findElement(By.id("welcome")).getText();
       System.out.println("The element text is " + elementText);
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.cssSelector(".double"))).perform();
        WebElement source = driver.findElement(By.className(".source"));
        WebElement destination = driver.findElement(By.className(".dest"));
        action.dragAndDrop(source,destination);
        //implicit wait >> wait until the action is done or return error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit wait >> wait until the action is done and proceed with the other actions
       // new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(driver.findElement(By.id("welcome"))));
        List <WebElement> courseList = driver.findElements(By.cssSelector(".course-list li"));
       System.out.println("The size is " + courseList.size());
        driver.findElement(By.id("inputEmail")).sendKeys("waleed@gmail.com");
        // Dropdwon with tag Select and has options
       Select coursesDropdown = new Select(driver.findElement(By.id("courses")));
       coursesDropdown.selectByIndex(2);
       //Dealing with alerts
      /*  driver.switchTo().alert().accept();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Waleed"); */
       driver.close();



    }
}
