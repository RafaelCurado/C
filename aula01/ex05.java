import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ex05 {

    final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Long> numberTable = readFiletoMap("bloco1/numbers.txt");
        System.out.println(numberTable);

        while (in.hasNextLine()) {
            long acum = 0l;
            long result = 0l;
            String line = in.nextLine();
            String processedLine = line.replace("-", " ").replace(',', ' ').toLowerCase();
            Scanner scline = new Scanner(processedLine);
            while (scline.hasNext()) {
                String text = scline.next();
                if (!text.equals("and")) {
                    if (!numberTable.containsKey(text)) {
                        System.err.println("ERROR");
                        System.exit(1);
                    }
                    long number = numberTable.get(text);

                    if (number <= acum) {
                        result += acum;
                        acum = 0l;
                    }

                    if (acum != 0 && number > acum) {
                        acum *= number;
                    } else {
                        acum = number;
                    }
                }

            }
            scline.close();
            result += acum;
            System.out.println(line + " -> " + result);
        }
    }

    private static Map<String, Long> readFiletoMap(String path) {
        Map<String, Long> result = new HashMap<String, Long>();
        try {

            Scanner scin = new Scanner(new File(path));
            while (scin.hasNextLine()) {
                String line = scin.nextLine().trim();
                if (line.length() > 0) {
                    String[] parts = line.split(" - ");
                    if (parts.length != 2) {

                        System.err.println("ERROR");
                        System.exit(1);
                    }
                    String key = parts[1].toLowerCase();
                    if (result.containsKey(key)) {
                        System.err.println("ERROR");
                        System.exit(0);
                    }
                    try {
                        result.put(key, Long.parseLong(parts[0]));
                    } catch (NumberFormatException e) {
                        System.err.println("ERROR");
                        System.exit(1);
                    }
                }
            }
            scin.close();
        } catch (IOException e) {
            System.err.println("ERROR");
            System.exit(1);
        }
        return result;
    }

}