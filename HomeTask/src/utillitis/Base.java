package utillitis;

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
	public static DelWithJson DelWithJson;
	
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
