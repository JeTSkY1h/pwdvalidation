package com.kim;

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

    public static boolean pwdValidationLength(String pwd) {
        return pwd.length() >= 8;
    }

    public static boolean pwdValidationSpecialKey(String pwd) {
        for(int i=0; i<pwd.length();i++){
            if(!Character.isLetterOrDigit(pwd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean pwdValidationDigit (String pwd) {
        for(int i=0; i<pwd.length();i++){
            if (Character.isDigit(pwd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean pwdValidationLowerCase (String pwd) {
        for(int i=0; i<pwd.length();i++){
            if (Character.isLowerCase(pwd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean pwdValidationUpperCase (String pwd) {
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
        String[] resArr = new String[pwds.length];
        for(int i=0; i< pwds.length; i++) {
            String pwd = pwds[i];
            String res = pwdValidNoRegExp(pwd);
            if(!res.equals("Okay")){
                resArr[i] = "Passwort: " + pwd + " // NOT SAFE! Info: " + res; 
            } else {
                resArr[i] = "Passwort: " + pwd + " // SAFE!"; 
            }
                System.out.println(resArr[i]);
        }
        return resArr;
    }
}
