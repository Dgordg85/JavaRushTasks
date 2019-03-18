package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {
        IncomeData company = new Company("UA", "JavaRush Ltd.", "Ivan", "Ivanov", 38, 501234567);
        IncomeDataAdapter adapterData = new IncomeDataAdapter(company);
        System.out.println(adapterData.getCompanyName());
        System.out.println(adapterData.getCountryName());
        System.out.println(adapterData.getName());
        System.out.println(adapterData.getPhoneNumber());
    }

    private static class Company implements IncomeData{
        private String countryCode;
        private String companyName;
        private String firstName;
        private String secondName;
        private int code;
        private int phone;

        public Company(String countryCode, String companyName, String firstName, String secondName, int code, int phone) {
            this.countryCode = countryCode;
            this.companyName = companyName;
            this.firstName = firstName;
            this.secondName = secondName;
            this.code = code;
            this.phone = phone;
        }

        @Override
        public String getCountryCode() {
            return this.countryCode;
        }

        @Override
        public String getCompany() {
            return this.companyName;
        }

        @Override
        public String getContactFirstName() {
            return this.firstName;
        }

        @Override
        public String getContactLastName() {
            return this.secondName;
        }

        @Override
        public int getCountryPhoneCode() {
            return this.code;
        }

        @Override
        public int getPhoneNumber() {
            return this.phone;
        }
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            String str = String.format("%010d)", data.getPhoneNumber());
            String prefix = str.substring(0, 3);
            String first = str.substring(3, 6);
            String second = str.substring(6, 8);
            String third = str.substring(8, 10);
            return String.format("+%d(%s)%s-%s-%s", data.getCountryPhoneCode(), prefix, first, second, third);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}