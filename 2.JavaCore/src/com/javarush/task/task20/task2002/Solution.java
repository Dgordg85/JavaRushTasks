package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу

        File yourFile = new File("C:/1/javarush.bin");
        OutputStream outputStream = new FileOutputStream(yourFile);
        User user = new User();
        user.setFirstName("Андрей");
        user.setLastName("Орлов");
        user.setBirthDate(new SimpleDateFormat("dd/M/yyyy").parse("25/05/1997"));
        user.setMale(true);
        user.setCountry(User.Country.RUSSIA);

        JavaRush javaRush = new JavaRush();
        javaRush.users.add(user);
        //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

        javaRush.save(outputStream);
        outputStream.close();

        JavaRush loadedObject = new JavaRush();
        InputStream inputStream = new FileInputStream(yourFile);
        loadedObject.load(inputStream);
        //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
        if (javaRush.equals(loadedObject)) System.out.println("Равны");
        else System.out.println("Не равны");
        inputStream.close();

    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream){
            PrintWriter writer = new PrintWriter(outputStream);
            if (this.users != null){
                for (User user : this.users){
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(user.getBirthDate());
                    writer.println(user.isMale());
                    writer.println(user.getCountry());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(new SimpleDateFormat("EEE MMMMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(reader.readLine()));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine()));
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
