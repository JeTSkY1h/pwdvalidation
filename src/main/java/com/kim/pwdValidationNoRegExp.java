package com.kim;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class pwdValidationNoRegExp {

    private static final String NO_DIGIT = "Passwörter müssen eine Zahl enthalten.";
    private static final String NO_SPECIAL_CHARACTER = "Passwörter müssen ein Sonderzeichen enthalten.";
    private static final String NOT_LONG_ENOUGH = "Passwörter müssen mindestens 8 Zeichen lang sein.";
    private static final String NO_UPPER_CASE = "Passwörter müssen einen Großgeschriebenen Buchstaben enthalten.";
    private static final String NO_LOWER_CASE = "Passwörter müssen einen kleingeschriebenen Buchstaben enthalten.";

    public static void main(String[] args) {
        boolean valid = false;
        Scanner keyboard = new Scanner(System.in);
        while(!valid) {
            System.out.println("Bitte gib dein Passwort ein.");
            String pwd = keyboard.nextLine();
            System.out.println(pwdValidNoRegExp(pwd));
            if(pwdValidNoRegExp(pwd).equals("Okay")) valid = true;
        }
        keyboard.close();
    }

    private static boolean pwdValidationLength(String pwd) {
        return pwd.length() >= 8;
    }

    private static boolean pwdValidationSpecialKey(String pwd) {
        for(int i=0; i<pwd.length();i++){
            if(!Character.isLetterOrDigit(pwd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private static boolean pwdValidationDigit (String pwd) {
        for(int i=0; i<pwd.length();i++){
            if (Character.isDigit(pwd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private static boolean pwdValidationLowerCase (String pwd) {
        for(int i=0; i<pwd.length();i++){
            if (Character.isLowerCase(pwd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private static boolean pwdValidationUpperCase (String pwd) {
        for(int i=0; i<pwd.length();i++){
            if (Character.isUpperCase(pwd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static String pwdValidNoRegExp(String pwd) {

        if(!pwdValidationLength(pwd)){
            return NOT_LONG_ENOUGH;
        }
        if(!pwdValidationUpperCase(pwd)){
            return NO_UPPER_CASE;
        }
        if(!pwdValidationLowerCase(pwd)){
            return NO_LOWER_CASE;
        }
        if(!pwdValidationSpecialKey(pwd)){
            return NO_SPECIAL_CHARACTER;
        }
        if(!pwdValidationDigit(pwd)) {
            return NO_DIGIT;
        }
        
        return "Okay";
      
    }

    public static String[] pwdArrayValidation(String[] pwds) {
        
        List<String> res = Arrays.asList(pwds)
            .stream()
            .map(pwd -> {
                String result = pwdValidNoRegExp(pwd);
                return result.equals("Okay") ?
                     "Passwort: " + pwd + " // SAFE!" : 
                     "Passwort: " + pwd + " // NOT SAFE! Info: " + result;
            })
            .toList();


        String[] resArr = new String[res.size()];
        return res.toArray(resArr);
    }
}
