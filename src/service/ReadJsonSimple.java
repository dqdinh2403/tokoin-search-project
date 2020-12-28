package service;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonSimple {
	
	private ReadJsonSimple() {}
	
	public static Object readJsonFromFile(String fileName) throws IOException, ParseException {
		FileReader reader = new FileReader(fileName);
		JSONParser jsonParser = new JSONParser();
		return jsonParser.parse(reader);
	}

}
