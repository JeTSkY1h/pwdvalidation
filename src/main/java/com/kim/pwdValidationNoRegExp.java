package com.kim;

public class pwdValidationNoRegExp {
    private static final String NO_DIGIT = "Passwörter müssen eine Zahl enthalten.";
    private static final String NO_SPECIAL_CHARACTER = "Passwörter müssen ein Sonderzeichen enthalten.";
    private static final String NOT_LONG_ENOUGH = "Passwörter müssen mindestens 8 Zeichen lang sein.";
    private static final String NO_UPPER_CASE = "Passwörter müssen einen Großgeschriebenen Buchstaben enthalten.";
    private static final String NO_LOWER_CASE = "Passwörter müssen einen kleingeschriebenen Buchstaben enthalten.";


    public static boolean pwdValidationLength(String pwd) {
        return pwd.length() >= 8;
    }

    public static boolean pwdValidationSpecialKey(String pwd) {
        char[] array = pwd.toCharArray();
        for(char c: array){
            System.out.println(Character.isAlphabetic(c));
            if(!Character.isAlphabetic(c) && !Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean pwdValidationDigit (String pwd) {
        char[] array = pwd.toCharArray();
        for(char c: array){
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean pwdValidationLowerCase (String pwd) {
        char[] array = pwd.toCharArray();
        for(char c: array){
            if (Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean pwdValidationUpperCase (String pwd) {
        char[] array = pwd.toCharArray();
        for(char c: array){
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

    public static String pwdValidNoRegExp(String pwd) {

        if(!pwdValidationUpperCase(pwd)){
            return NO_UPPER_CASE;
        }
        if(!pwdValidationLowerCase(pwd)){
            return NO_LOWER_CASE;
        }
        if(!pwdValidationLength(pwd)){
            return NOT_LONG_ENOUGH;
        }
        if(!pwdValidationSpecialKey(pwd)){
            return NO_SPECIAL_CHARACTER;
        }
        if(!pwdValidationDigit(pwd)) {
            return NO_DIGIT;
        }
        
        return "Okay";
        
        
    }
}
