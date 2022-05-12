package VisitingWebsites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethod {

    public static void main (String [] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file://C:\\Users\\WAE021\\IdeaProjects\\Selenium_QACart\\src\\test\\resources\\index.html");
       String url= driver.getCurrentUrl();
       System.out.println("The current URL is "+url);
       String title = driver.getTitle();
       System.out.println("The current title is "+title);
       String elementText = driver.findElement(By.id("welcome")).getText();
       System.out.println("The element text is " + elementText);
        driver.close();



    }
}
