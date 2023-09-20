package ForMe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleTestingForIphone13{
    public static void main (String args[]) throws IOException {
        // This is for set up selenium Web driver
        WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();

       // this is for wait for the element
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        // to navigate to google .com
        driver.get("https://www.google.com");

       // fine element for search bottom
       WebElement s=  driver.findElement(By.xpath("//*[@class='gLFyf']"));

       // here to take a screenShot
       File F=((TakesScreenshot )driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(F,new File(".//"));
        File fil = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fil,new File(".//screenshot/screen.jpg"));

       s.click();
       s.sendKeys("iphone13");
       s.sendKeys(Keys.ENTER);
       //getting the title  for the page
        System.out.println(driver.getTitle());

      // list of element for searching
       List<WebElement> Elements = driver.findElements(By.xpath(""));
       for(WebElement element:Elements){
           System.out.println(element.getText());
       }

      WebElement check= driver.findElement(By.xpath("//*[.=\"Apple iPhone 13\"]"));
        check.getText();
       String toCheck= check.getText();
       if(toCheck.contentEquals("Apple iPhone 13"))
        System.out.println("passCheck");
        else
        System.out.println("failing to find i phone 13 ");

        driver.close();


    }
}
