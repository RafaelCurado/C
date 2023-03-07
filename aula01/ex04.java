import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class ex04 {
    public static void main(String[] args) {
        Map<String, Integer> numbers = readNumberFile("bloco1/numbers.txt");

        System.out.printf("result: " + numbers);

    

    }


    static Map<String, Integer> readNumberFile(String path) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        
        try {
            Scanner sc = new Scanner(new File(path));
            while(sc.hasNextLine())  {
                String line = sc.nextLine().trim();
                if (line.length() > 0) {
                    String[] parts = line.split(" - ");
                    if (parts.length != 2) {
                        System.err.println("Error: syntax error in number file!");
                        System.exit(1);
                    }
                    String key = parts[1].toLowerCase();
                    if(result.containsKey(key)) {
                        System.err.println("ERROR: repeated number \" " + key + "\" in number file!");
                        System.exit(1);
                    }
                    try {
                        result.put(key, Integer.parseInt(parts[0]));   
                    } catch(NumberFormatException e) {
                        System.err.println("ERROR: invalid number \"" + parts[0] +"\" in number file");
                        System.exit(1);
                    }
                }
            }
            sc.close();
        } catch(IOException e) {
            System.err.println("Error reading number file!");
            System.exit(1);
        }
        return result;
    }



}