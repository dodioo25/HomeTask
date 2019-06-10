package PageObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import utillitis.Base;
import utillitis.DelWithJson;

public class SearchResultsPage extends Base
{
	@FindBy(how = How.CLASS_NAME, using = "repo-list-item")
	protected List<WebElement> Resullts ;
	
	@FindBy(how = How.CSS, using = "div.codesearch-results > div > div.paginate-container > div > a")
	protected List<WebElement> Pages ;
	
	public void PrintTitel(int resulltNum , JsonObject o) // Checks whether there is a title for a specific result and put it in json object.
	{
			try {
			String titel=driver.findElement(By.cssSelector("div > ul > li:nth-child("+resulltNum+") > div > h3 > a")).getText();
			System.out.println("Titel: "+titel);
			o.addProperty("Titel",titel);
			}
			catch (Exception e) {
				return;
			}		
	}
	public void PrintDiscription(int resulltNum , JsonObject o) 
	{
			try {
			String Discription=driver.findElement(By.cssSelector("div > ul > li:nth-child("+resulltNum+") > div > p")).getText();
			System.out.println("Discription: "+Discription);
			o.addProperty("Discription",Discription);
			}
			catch (Exception e) {
				return;
			}
	}
	public void PrintTags(int resulltNum,JsonObject o) 
	{
				List<WebElement> tags=driver.findElements(By.cssSelector("div > ul > li:nth-child("+resulltNum+") > div > div.topics-row-container > a"));
				if(tags.isEmpty())
				{
					return;
				}
				else {
					String x=null;
					System.out.print("Tags:");
					for(int i=0;i<tags.size();i++)
					{
						System.out.print(tags.get(i).getText()+" ");
						x=x+tags.get(i).getText()+" ";
					}
					o.addProperty("Tags", x);
				}
				System.out.println("");
	}
	public void PrintLanguge(int resulltNum,JsonObject o) 
	{
			try {
			String Languge =driver.findElement(By.cssSelector("div > ul > li:nth-child("+resulltNum+") > div > div > div > span > span:nth-child(2)")).getText();
			System.out.println("Languge: "+Languge);
			o.addProperty("Languge",Languge);
			}
			catch (Exception e) {
				return;
			}
	}
	public void PrintStarsAmaount(int resulltNum,JsonObject o) 
	{
			try {
			String StarsAmaount =driver.findElement(By.cssSelector(" div > ul > li:nth-child("+resulltNum+") > div > div.flex-auto > a")).getText();
			System.out.println("StarsAmaount: "+StarsAmaount);
			o.addProperty("StarsAmaount",StarsAmaount);
			}
			catch (Exception e) {
				return;
			}
	}
	public void PrintTime(int resulltNum,JsonObject o) 
	{
			try {
			String Time =driver.findElement(By.cssSelector(" div > ul > li:nth-child("+resulltNum+") > div > div > p > relative-time")).getText();
			System.out.println("Time: "+Time);
			o.addProperty("Time",Time);
			}
			catch (Exception e) {
				System.out.println("Time: Empty!!!");
			}
	}
	
	public JsonObject PrintCardResult(int resulltNum) 
	{ 
		JsonObject obj = new JsonObject();
		sr.PrintTitel(resulltNum,obj);
		sr.PrintDiscription(resulltNum, obj);
		sr.PrintTags(resulltNum,obj);
		sr.PrintTime(resulltNum,obj);
		sr.PrintLanguge(resulltNum,obj);
		sr.PrintStarsAmaount(resulltNum,obj);
		System.out.println(obj.toString());
		System.out.println("----------------------------------");
		return obj;
	}
	
	public void EnterToPageOneToFive(String num) throws InterruptedException 
	{
		for (int i = 0; i < Pages.size(); i++) 
		{
			String page=Pages.get(i).getText();
			
			if (page.equals(num)  ) 
			{
				Pages.get(i).click();
			}
		}
		Thread.sleep(3000);
		ManagePages.initElements();
	}	
	public void PrintAllCardResultsIn5Page() throws InterruptedException 
	{
		
		JsonArray array=new JsonArray();
		String timeStemp = new SimpleDateFormat("yyyy-MM-dd_HH").format(Calendar.getInstance().getTime());
		String jsonpath = "./Jsons/SecurityResultGitHub-"+timeStemp+".json";
		try (FileWriter file = new FileWriter(jsonpath))
		{
			file.write(array.toString());
			file.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		JsonParser jsonParser = new JsonParser();
	      try {
	            Object obj = jsonParser.parse(new FileReader(jsonpath));
	            JsonArray jsonArray = (JsonArray)obj;
	            boolean flag=true;

	            for (int j = 1; j <= 5 ; j++) {
					
					for(int i=0;i<Resullts.size();i++)
					{
						jsonArray.add(PrintCardResult(i+1));
						FileWriter file = new FileWriter(jsonpath);
				        file.write(jsonArray.toString());
				        file.flush();
				        file.close();
				        if (flag) {
				        	task2 taskrunner=new task2();
				        	taskrunner.start();
				        	flag=false;
						}
				        task2.sleep(10000);
				        
					}
					EnterToPageOneToFive(""+(j+1));
					
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        	}
	      
	}
}

class task2 extends Thread{
	public void run() {
		System.out.println("Thrad2-start");
		 DelWithJson.BraekJsonToJsonObjectFiles();
	}
}
