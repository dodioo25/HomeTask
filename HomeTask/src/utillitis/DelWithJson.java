package utillitis;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DelWithJson extends Base
{
	public static void BraekJsonToJsonObjectFiles(String JsonPath) {
		
		JsonParser parser = new JsonParser();

        try (Reader reader = new FileReader(JsonPath)) {

        	JsonArray JsonArray = (JsonArray) parser.parse(reader);
        	
        	for (int i = 0; i < JsonArray.size(); i++) {
        		JsonObject jsonobject =JsonArray.get(i).getAsJsonObject();
           
        		JsonObject obj = new JsonObject();
            	obj.add("Titel",jsonobject.get("Titel"));
            	obj.add("Tags" , jsonobject.get("Tags"));
            	obj.add("Languge" , jsonobject.get("Languge"));
            	
            	String timeStemp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
            	
            	String jsonpathtosave = "C:\\temp\\SecurityResultGitHub-OrderOfTheResult"+(i+1)+"-"+timeStemp+".json";
        		try (PrintWriter file=new PrintWriter(jsonpathtosave))
        		{
        			file.write(obj.toString());
        			file.flush();
        		}
        		catch (Exception e) {
        			e.printStackTrace();
        		}
            	
			}
            }
        catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
