package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Solution data = new Solution();
        data.fillInPropertiesMap();
    }

    public void fillInPropertiesMap() throws Exception {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader stream = new BufferedReader(new FileReader(reader.readLine()));
        FileInputStream stream = new FileInputStream("C:/1/1.properties");
        Solution sol = new Solution();
        sol.load(stream);
        stream.close();

        for (Map.Entry<String, String> entry : properties.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

//        BufferedOutputStream bufOut = new BufferedOutputStream(new FileOutputStream("C:/1/2.properties"));
//        sol.save(bufOut);
//        bufOut.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String str;
        while((str = reader.readLine()) != null){
            String[] ignorArr = {"!", "#"};
            try {
                String firstSymbol = str.substring(0, 1);
                if (!Arrays.asList(ignorArr).contains(firstSymbol)) {

                    String key = str.substring(0, getSplitter(str)).trim();
                    String value = str.substring(getSplitter(str) + 1);



                    while (value.endsWith("\\")){
                        value = value.substring(0, value.length() - 1);
                        value += trimBeginString(reader.readLine());
                    }

                    properties.put(clearString(key), trimBeginString(clearString(value)));
                }
            }
            catch (StringIndexOutOfBoundsException e){
            }
        }
    }

    private static int getIndexSplitter(String str, String symbol){
        int index;
        int pos = 0;
        while ((index = str.indexOf(symbol, pos)) > -1){
            if (str.charAt(index - 1) != '\\') {
                break;
            } else{
                pos += index;
            }
        }
        return index;
    }

    private  static int getSplitter(String str){
        int index1 = getIndexSplitter(str, ":"),
                index2 = getIndexSplitter(str, "=");
        if (index1 == -1) return index2;
        if (index2 == -1) return index1;
        if (index1 < index2){
            return index1;
        } else {
            return index2;
        }
    }

    private static String clearString(String str){
        str = str.replaceAll("\\\\\\s\\b", " ");
        str = str.replaceAll("[\\\\]{2}", "\\\\");
        str = str.replaceAll("[\\\\][:]", ":");
        str = str.replaceAll("[\\\\][=]", "=");

        return str;
    }

    private static String trimBeginString(String str){
        Pattern pattern = Pattern.compile("^\\s*(.*)");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        return matcher.group(1);
    }


}
