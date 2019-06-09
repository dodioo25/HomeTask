package PageObject;

import org.openqa.selenium.support.PageFactory;

import utillitis.Base;

public class ManagePages extends Base
{
	public static void initElements() {
		hp=PageFactory.initElements(driver, HomePage.class);
		sr=PageFactory.initElements(driver, SearchResultsPage.class);
	}

}
