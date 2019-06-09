package Scripts;

import utillitis.Base;

public class Scripts extends Base
{
	public static void Task1() throws InterruptedException {
		setup();
		hp.serchAction("security");
		sr.PrintAllCardResultsIn5Page();
		finish();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Task1();
	}
}
