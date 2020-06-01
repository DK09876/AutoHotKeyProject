package functions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Functions {
	private static final Map<String, String> charlist = new HashMap<>();
    static {
        charlist.put("ctrl", "^");
        charlist.put("alt", "!");
        charlist.put("shift","+");
        charlist.put("win","#");
    }
        
	public void WriteToScript(String input) throws IOException {
		//writes string to file
		BufferedWriter Writer = new BufferedWriter(new FileWriter("YourHotKeys.ahk",true));
		Writer.write(input);
		Writer.newLine();
		Writer.close();
	}
	
	public void AutoComplete(String keys,String input) throws IOException {
		//this method creates a hotkey to output given input string such as Ctrl+D to always type "Hello World!"
		keys= ConvertToChar(keys);
		String result=keys + ":: " +"Send, " + input;
		WriteToScript(result);
	}
	
	public void AutoCorrect(String key,String input) throws IOException {
		//this method autocorrects given key such as "AHK" to "AutoHotKey"
		//key is the string that will be corrected 
		String result="::" + key + "::" + input;
		WriteToScript(result);
	}
	
	public void RunProgram(String keys,String input) throws IOException {
		//this method creates a hotkey to open a program/website such as windows+p to open "Spotify.exe" or "https"
		//make sure to use filepath to the exe file (however some applications like chrome,notepad,spotify dont need filepaths to be specified)
		//"taskmgr" to open taskmanager
		keys=ConvertToChar(keys);
		String result= keys+ "::" + "Run, " + input;
		WriteToScript(result);
	}
	
	public String ConvertToChar(String keys) {
		//this method gets the keys and converts it to chars that AHK understands
		String result="";
		String[] keyset = keys.split(" ");
		for(String thiskey: keyset) {
			if (charlist.containsKey(thiskey))
				result+=charlist.get(thiskey);
			else
				result+=thiskey;
		}
		System.out.print(result);
		return result;
	}
	
	public void loadtextscript() throws IOException {
		String result="";
		Scanner reader = new Scanner(new File("TextlanguagetoNormal.txt"));
		while (reader.hasNext()) {
			result+=reader.next();
		}
		WriteToScript(result);
		reader.close();
	}
	
	public void LoadScriptTest() throws IOException {
		//ctrl+alt+o to open a dialogue box to test if script is working 
		WriteToScript("^!o::\r\n" + "MsgBox, Script is working!");
		System.out.print("a");
	}
	
	public void deleteallscripts() throws IOException {
		//this method deletes all scripts in the YourHotKeys file and puts it in PreviousScripts
		String oldscripts="";
		Scanner reader = new Scanner(new File("YourHotKeys.ahk"));
		while (reader.hasNext()) {
			oldscripts+=reader.next();
		}
		new FileWriter("YourHotKeys.ahk", false).close();
		new FileWriter("PreviousScripts.txt", false).close();
		BufferedWriter Writer = new BufferedWriter(new FileWriter("PreviousScripts.txt",true));
		Writer.write(oldscripts);
		Writer.close();
	}
	
}
