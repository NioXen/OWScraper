/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owscraper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HashMapReader {
    public static HashMap<String, String> ReadFile(String filePath, String delimiter){
        String line;
        HashMap<String, String> map = new HashMap<>();
        try{
            BufferedReader rdr = new BufferedReader(new FileReader(filePath));

            while((line = rdr.readLine()) != null){
                String[] split = line.split(delimiter, 2);
                if(split.length >= 2){
                    String k = split[0];
                    String v = split[1];
                    map.put(k, v);
                } else {
                    System.out.println(line + "not read");
                }
            }
        }catch(IOException e){
                System.err.println("IOException: " + e.getMessage());
                map = null;
        }
        return map;
    }
}
