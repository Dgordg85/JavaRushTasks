package com.javarush.task.task20.task2001;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File file = File.createTempFile("human.bin", null);
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (ivanov.equals(somePerson)) System.out.println("Равны");
            else System.out.println("Не равны");

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            if (this.name != null) {
                outputStream.write(this.name.getBytes());
                outputStream.write(System.getProperty("line.separator").getBytes());
                if (this.assets != null) {
                    for (Asset asset : assets) {
                        outputStream.write((asset.getName() + " " + asset.getPrice()).getBytes());
                        outputStream.write(System.getProperty("line.separator").getBytes());
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
           BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           String str;
           if ((str = reader.readLine()) != null) this.name = str;

           while (reader.ready()){
               String[] assets = reader.readLine().split(" ");
               this.assets.add(new Asset(assets[0], Double.parseDouble(assets[1])));
           }

           reader.close();
        }
    }
}
