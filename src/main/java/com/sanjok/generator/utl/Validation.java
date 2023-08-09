/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.utl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sanjok
 */
public class Validation {

    private Pattern pattern;
    private Matcher matcher;

    public static Boolean checklength(String string) {
        string = string.trim();
        return string.length() > 0;

    }

    public static Boolean isEmpty(String validate) {

        return validate.isEmpty();

    }

    //fname of customer_detail page 
    public static Boolean name(String fname) {

        boolean isValid = false;
        String expression = ("[A-Z][a-zA-Z]*");
        CharSequence inputStr = fname;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    //address 
    public static Boolean address(String address) {

        boolean isValid = false;
        String expression = ("[A-Z][a-zA-Z]*");
        CharSequence inputStr = address;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

//email
    public static Boolean email(String email) {

        boolean isValid = false;
        String expression = "^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    //contact number of customer detail page

    public static Boolean contact(String contact) {

        boolean isValid = false;
        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = contact;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static Boolean JobBiLNumber(String bill) {

        boolean isValid = false;
        String expression = "^[a-zA-Z0-9]+$";
        CharSequence inputStr = bill;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static Boolean company_name(String lastname) {
        boolean isValid = false;
        String expression = ("[a-zA-z]+([ '-][a-zA-Z]+)*");
        CharSequence inputStr = lastname;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}
