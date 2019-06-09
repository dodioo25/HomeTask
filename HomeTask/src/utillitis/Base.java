package utillitis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.HomePage;
import PageObject.ManagePages;
import PageObject.SearchResultsPage;

public class Base {
	
	public static WebDriver driver;
	public static HomePage hp;
	public static SearchResultsPage sr;
	public static String timeStemp = new SimpleDateFormat("yyyy-MM-dd_H").format(Calendar.getInstance().getTime());
	
    public static void setup(){
		System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://github.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ManagePages.initElements();
    }
	
    public static void finish(){
		driver.quit();
    }
	
}
