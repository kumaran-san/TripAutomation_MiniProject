package TripAutomationProject;
import java.io.File;
import java.time.Duration;
import java.util.List;
//import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MiniProjectUtilities 
{
	public WebDriver driver;
//    public Scanner scanner;

    public WebDriver setupDriver()
    {
    	//Invoking the driver method from the DriverSetup class
    	driver=DriverSetup.launchBrowser();
    	return driver;
    }
    
    public void navigateToOffersLink()
    {
    	//Navigating to the offers link
    	driver.findElement(By.xpath("//a[@title='Offers']")).click();
    }
    
    //Validating the Title of the page
    public void validatePageTitle() 
    {
        String title = driver.getTitle();
        System.out.println("The title of the Page is::"+""+title);
        if(!title.equals("Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com")) {
            System.out.println("Title does not match");
        } else {
            System.out.println("Title of the page matches");
        }
    }
    //Validating the banner text
    public  void validateBannerText() {
        WebElement bannerText = driver.findElement(By.xpath("//h2[@class='wfull bxs']"));
        if(!bannerText.getText().equals("Great Offers & Amazing Deals")) {
            System.out.println("Banner text does not match");
        } else {
            System.out.println("Banner text matches");
        }
    }
    //Capturing the screenShot of the window
    public void captureScreenshot() {
        try {
            TakesScreenshot ts = ((TakesScreenshot) driver);
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\Users\\2318580\\eclipse-workspace\\TripAutomationMiniProject\\src\\test\\java\\TripAutomationProject\\ScreenShots\\projectSnap.png");
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception e) {
            System.out.println(e);
        }
        finally 
        {
        	System.out.println("Screen Shot of the window has successfully captured!!");
        	System.out.println();
        	
        }
    }
    //Navigating to the Holiday Link
    public void navigateToHolidayLink() {

    	driver.navigate().back();
        driver.findElement(By.xpath("//span[normalize-space()='Holidays']")).click();
    }
    //clicking the search button
    public void searchButton() throws InterruptedException
    {
    	TimeUnit.SECONDS.sleep(6);
    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(By.id("BE_holiday_search_btn")));
    	
        driver.findElement(By.id("BE_holiday_search_btn")).click();
    	
    }
    //Displaying the holiday packages list
    public void listHolidayPackages() 
    {
    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
         List<WebElement> packages = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[@class='package-name']")));
         List<WebElement> price = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[@class='final-price']")));
         System.out.println("The list of five holiday packages:::");
         System.out.println("_______________________________________________");
         System.out.println();
         for (int i = 0; i < 5; i++) {
             WebElement pack = packages.get(i);
             String holidaysList=pack.getText();
             System.out.println("PackageName::"+holidaysList);
             WebElement priceList=price.get(i);
             String trip_price=priceList.getText();
             System.out.println("PackagePrice::"+trip_price);
             System.out.println();
            
            
        }

}
    //closing the browser
    public void quitBrowser()
    {
    	
    	driver.quit();
    	System.out.println("Browser closed successfully!!!");
    }



}
