package TripAutomationProject;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup 
{
	static WebDriver driver;
	static Scanner scanner;
	static Properties urlFile= new Properties();

	public static WebDriver launchBrowser()
	{
		System.out.println("Enter the browser name to launch (chrome/edge): ");
		scanner = new Scanner(System.in);
        String browserName = scanner.next();
       try {
			FileInputStream link = new FileInputStream("C:\\Users\\2318580\\eclipse-workspace\\TripAutomationMiniProject\\src\\test\\java\\TripAutomationProject\\AutomationProject.properties");
			urlFile.load(link);
			link.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(urlFile.getProperty("baseUrl"));
                driver.manage().window().maximize();
                break;
            case "edge":
            	WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(urlFile.getProperty("baseUrl"));
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Invalid browser name. Please enter 'chrome' or 'edge'.");
//                return driver;
        }
// Implicit Wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;		
	}

}
