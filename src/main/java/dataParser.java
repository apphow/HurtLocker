
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dataParser {
    private String dataParser;
    public void  DataParser() throws IOException {this.dataParser = newFile();}

    public static String newFile() throws IOException {

        //create JsonParser object

        //read  file data to String
        //File file = new File("/Users/ahoward/Desktop/projects/HurtLocker/target/classes/RawData.txt");
        JsonParser jsonParser = new JsonFactory().createParser(new File("/Users/ahoward/Desktop/projects/HurtLocker/target/classes/RawData.txt"));
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner((Readable) jsonParser)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
                System.out.println(result);
            }
        }
        return result.toString();
    }

    public String getDataParser() {
        return dataParser;
    }
    public String changeNameToLowerCase(String str) {

        Pattern pattern = Pattern.compile("naMe", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str.toLowerCase());

        return matcher.replaceAll("naMe");
    }

    public String removeHashNewLine(String str) {

        Pattern pattern = Pattern.compile("[##]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("\n");
    }
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


