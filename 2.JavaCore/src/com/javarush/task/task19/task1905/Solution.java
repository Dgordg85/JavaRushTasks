package com.javarush.task.task19.task1905;

import com.sun.rowset.internal.Row;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Customer customer = new Test(null, null, "JavaRush Ltd.", "Ukraine");
        Contact contact = new Test("Ivanov, Ivan", "+38(050)123-45-67", null, null);
        RowItem item = new DataAdapter(customer, contact);

        System.out.println(item.getCountryCode());
        System.out.println(item.getCompany());
        System.out.println(item.getContactFirstName());
        System.out.println(item.getContactLastName());
        System.out.println(item.getDialString());
    }

    public static class Test implements Customer, Contact{
        private String name;
        private String phoneNumber;
        private String companyName;
        private String countryName;

        public Test(String name, String phoneNumber, String companyName, String countryName) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.companyName = companyName;
            this.countryName = countryName;
        }

        @Override
        public String getCompanyName() {
            return companyName;
        }

        @Override
        public String getCountryName() {
            return countryName;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String str = null;
            for (Map.Entry<String, String> entry : countries.entrySet()){
                if (entry.getValue().equals(customer.getCountryName())){
                    str = entry.getKey();
                    break;
                }
            }
            return str;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(" ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(" ")[0].replace(",", "");
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replaceAll("[^+\\d]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}