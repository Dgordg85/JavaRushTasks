package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        //File file = new File("C:/1/1.txt");
        Scanner sc = new Scanner(Paths.get("C:/1/1.txt"), "Windows-1251");
        PersonScanner psc = new PersonScannerAdapter(sc);

        System.out.println(psc.read());
        System.out.println(psc.read());
        psc.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws ParseException {
            Person person = null;
            if (fileScanner.hasNext()){
                String str[] = fileScanner.nextLine().split(" ");
                SimpleDateFormat pattern = new SimpleDateFormat("dd MM yyyy");
                Date date = pattern.parse(String.format("%s %s %s", str[3], str[4], str[5]));
                person = new Person(str[1], str[2], str[0], date);
            }
            return person;
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}
