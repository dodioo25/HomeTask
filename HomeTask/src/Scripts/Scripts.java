package Scripts;


import utillitis.Base;

public class Scripts extends Base
{
	public static String Task1() throws InterruptedException {
		setup();
		hp.serchAction("security");
		String jsonPath = sr.PrintAllCardResultsIn5Page();
		finish();
		return jsonPath;
	}
	
	public static void Task2(String JsonPath) {
		
		utillitis.DelWithJson.BraekJsonToJsonObjectFiles(JsonPath);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		String jsonPath= Task1();
		Task2(jsonPath);
	}
}
