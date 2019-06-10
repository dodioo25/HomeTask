package Scripts;


import utillitis.Base;

public class Scripts extends Base
{
	public static void Task() throws InterruptedException { 
		setup();
		ServiceBar.serchAction("security");
		SearchResultsPage.PrintAllCardResultsIn5Page();
		finish();
	}
	
	public static void main(String[] args) throws InterruptedException { //main method
		Task();
	}
}
