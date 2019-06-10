package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utillitis.Base;

public class ServiceBar extends Base// ServiceBar Element's in "github"
{
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "All GitHub")
	protected WebElement serchButton ;

	@FindBy(how = How.CLASS_NAME, using = "header-search-input")
	public WebElement serchLine;
	
	public void serchAction(String x) //This method is serching string in github website
	{
		serchLine.click();
		serchLine.clear();
		serchLine.sendKeys(x);
		serchButton.click();
	}
}