package PageObject;

import org.openqa.selenium.support.PageFactory;

import utillitis.Base;

public class ManagePages extends Base
{
	public static void initElements() {
		ServiceBar=PageFactory.initElements(driver, ServiceBar.class);
		SearchResultsPage=PageFactory.initElements(driver, SearchResultsPage.class);
	}

}
