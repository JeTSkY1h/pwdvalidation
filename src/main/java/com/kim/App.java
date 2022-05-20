package com.kim;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Time is what determines security. With enough time nothing is unhackable." );
    }

    public static boolean pwdValidationLength(String pwd) {
        return pwd.length() >= 8;
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

    public static boolean pwdValidationUpperCase (String pwd) {
        char[] array = pwd.toCharArray();
        for(char c: array){
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean pwdValidNoRegExp(String pwd) {
        return pwdValidationLength(pwd) && pwdValidationDigit(pwd) && pwdValidationUpperCase(pwd);
    }

    public static boolean pwdValid(String pwd) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pwd);
        return matcher.find();
    }
    
}
