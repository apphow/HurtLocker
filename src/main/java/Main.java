import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import org.apache.commons.io.IOUtils;

import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;

    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        dataParser groceryItems = new dataParser();
        groceryItems.displayGroceryItems();
        System.out.println(groceryItems);
    }
}
