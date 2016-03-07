
import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

import java.util.Map;

import java.util.Set;
import java.util.TreeMap;

public class Frequency {



    public static void main(String[] file) throws FileNotFoundException, IOException {

        if (file.length == 0) {

           // System.out.println("Usage: java WordCounter targetfile");

           // System.exit(0);

        }

 

        BufferedReader bufferedReader = null;

        bufferedReader = new BufferedReader(new FileReader("WarandPeace.txt"));

        String inputLine = null;

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        String outFile = "D:/tf.csv";

       // boolean checkExist = new File(outFile).exists();
 

 

 

        try {

             

            while ((inputLine = bufferedReader.readLine()) != null) {

            String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");

 

                for (int wordCounter = 0; wordCounter < words.length; wordCounter++) {

                    String key = words[wordCounter].toLowerCase();

                    if (key.length() > 0) {

                        if (map.get(key) == null) {

                            map.put(key, 1);

                        }

                        else {

                            int value = map.get(key).intValue();

                            value++;

                            map.put(key, value);

                        }

                    }
                     // FileWriter writer = new FileWriter(outFile);

                    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

                    for (Map.Entry<String, Integer> entry : entrySet) {

                        System.out.println(entry.getValue() + "\t" + entry.getKey());

                    }

 

                }

             

            }

        }

        catch (IOException error) {

            System.out.println("Invalid File"); 

        }

        finally {

            bufferedReader.close();

 

 

        }

    }

}
