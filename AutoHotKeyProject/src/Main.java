import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public void WriteToScript(String input) {
		//writes string to file
	}
	
	public String AutoComplete(String keys,String input) {
		//this method creates a hotkey to output given input string such as Ctrl+D to always type "Hello World!"
		keys= ConvertToChar(keys);
		String result=keys + ":: " +"Send, " + input;
		return result;
	}
	
	public String AutoCorrect(String key,String input) {
		//this method autocorrects given key such as "AHK" to "AutoHotKey"
		//key is the string that will be corrected 
		String result="::" + key + "::" + input;
		return result;
	}
	
	public String RunProgram(String keys,String input) {
		//this method creates a hotkey to open a program/website such as windows+p to open "Spotify.exe" or "https"
		//make sure to use filepath to the exe file (however some applications like chrome,notepad,spotify dont need filepaths to be specified)
		//"taskmgr" to open taskmanager
		keys=ConvertToChar(keys);
		String result= keys+ "::" + "Run, " + input;
		return result;
	}
	
	public String ConvertToChar(String keys) {
		//this method gets the keys and converts it to chars that AHK understands
		return null;
	}
	public void loadtextscript() throws FileNotFoundException {
		String result="";
		Scanner reader = new Scanner(new File("TextlanguagetoNormal.txt"));
		while (reader.hasNext()) {
			result+=reader.next();
		}
		WriteToScript(result);
		reader.close();
	}
	public void LoadScriptTest() {
		//ctrl+alt+o to open a dialogue box to test if script is working 
		WriteToScript("^!o::\r\n" + "MsgBox, Script is working!");
	}
}
