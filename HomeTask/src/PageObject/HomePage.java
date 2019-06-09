package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utillitis.Base;

public class HomePage extends Base
{
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "All GitHub")
	protected WebElement serchButton ;

	@FindBy(how = How.CLASS_NAME, using = "header-search-input")
	public WebElement serchLine;
	
	public void serchAction(String x) 
	{
		serchLine.click();
		serchLine.clear();
		serchLine.sendKeys(x);
		serchButton.click();
		
	}
}