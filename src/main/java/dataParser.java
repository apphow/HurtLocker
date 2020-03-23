import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dataParser<rootNode> {
    private String dataInfo;

    public dataParser() throws IOException {
        this.dataInfo = newFile();
    }

    public static String newFile() throws IOException {

        //create JsonParser object

        //read  file data to String
        File file = new File("/Users/ahoward/Desktop/projects/HurtLocker/target/classes/RawData.txt");
        //JsonParser jsonParser = new JsonFactory().createParser(new File("/Users/ahoward/Desktop/projects/HurtLocker/target/classes/RawData.txt"));
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
                System.out.println(result);
            }
        }
        return result.toString();
    }

    public String getDataParser() {
        return dataInfo;
    }

    public void displayGroceryItems() {
        changeNameToLowerCase();
        removeHashNewLine();
        replaceMilkMilk();
        replaceBread();
        replacePrice();
    }

    public String changeNameToLowerCase() {

        Pattern pattern = Pattern.compile("naMe", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dataInfo);

        return matcher.replaceAll("name");
    }

    public String removeHashNewLine() {

        Pattern pattern = Pattern.compile("[##]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dataInfo);
        return matcher.replaceAll("\n");
    }

    public String replaceMilkMilk() {

        Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dataInfo);
        return matcher.replaceAll("Milk");
    }

    public String replaceBread() {
        Pattern pattern = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dataInfo);
        return matcher.replaceAll("Bread");
    }

    public void replacePrice() {
        int count = 0;
        Pattern pattern = Pattern.compile("price", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dataInfo);

        while(matcher.find()) {
            count++;
        }

        System.out.println("Price:   1.23        seen: " + count + " " + "times");
    }
    /*
    byte[] jsonData = Files.readAllBytes(Paths.get("RawData.txt"));

    ObjectMapper objectMapper = new ObjectMapper();

    //create JsonNode
    JsonNode rootNode = objectMapper.readTree(jsonData);


//update JSON data
((dataParser) rootNode).put("id", 500);
//add new key value
((ObjectNode) rootNode).put("test", "test value");
//remove existing key
((ObjectNode) rootNode).remove("role");
((ObjectNode) rootNode).remove("properties");
objectMapper.writeValue(new File("updated_emp.txt"), rootNode);


     */
    }

/*
    public class HamletParser {

        private String hamletData;

        public HamletParser(){
            this.hamletData = loadFile();
        }

        private String loadFile(){
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("hamlet.txt").getFile());
            StringBuilder result = new StringBuilder("");

            try(Scanner scanner = new Scanner(file)){
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    result.append(line).append("\n");
                }

                scanner.close();
            }catch(IOException e){
                e.printStackTrace();
            }

            return result.toString();
        }

        public String getHamletData(){
            return hamletData;
        }

    /*
        // Create a pattern to be searched
        Pattern pattern = Pattern.compile("geeks");

        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher("geeksforgeeks.org");
     */

    /*
      Pattern pattern = Pattern.compile(REGEX);

      // get a matcher object
      Matcher matcher = pattern.matcher(INPUT);
      INPUT = matcher.replaceAll(REPLACE);



        public String changeHamletToLeon( String str) {

            Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(str);

            return matcher.replaceAll("Leon");
        }

        public String changeHoratioToTariq(String str) {

            Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(str);

            return matcher.replaceAll("Tariq");
        }

     */


