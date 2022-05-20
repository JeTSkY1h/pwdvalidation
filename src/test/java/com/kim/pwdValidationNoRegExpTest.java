package com.kim;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class pwdValidationNoRegExpTest {
    @Test
    void shouldBeTrueBecausePwdIsLongEnough(){
        //given
        String pwd = "IchBinLangGenug";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationLength(pwd);
        //when
        assertTrue(res);

    }
    @Test
    void shouldBeFalseCausePwdIsToShort(){
        //given
        String pwd = "IchBin";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationLength(pwd);
        //when
        assertFalse(res);

    }

    @Test
    void shouldBeTrueBecausePwdHasUpperCaseCharacter(){
        //given
        String pwd = "IchBinLangGenug";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationUpperCase(pwd);
        //when
        assertTrue(res);

    }

    @Test
    void shouldBeFalseCauseNoUpperCaseCharacter(){
        //given
        String pwd = "ichbinlangenugaberdasistegal";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationUpperCase(pwd);
        //when
        assertFalse(res);

    }

    @Test
    void shouldBeTrueCauseHasLowerCaseCharacter(){
        //given
        String pwd = "ICHBINLANGGENUGABERDASISTEGAl";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationLowerCase(pwd);
        //when
        assertTrue(res);

    }

    @Test
    void shouldBeFalseCauseNoLowerCaseCharacter(){
        //given
        String pwd = "ICHBINLANGGENUGABERDASISTEGAL";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationLowerCase(pwd);
        //when
        assertFalse(res);

    }

    @Test
    void shouldBeFalseCauseNoNumber(){
        //given
        String pwd = "ICHBINLANGGENUGABERDASISTEGAL";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationDigit(pwd);
        //when
        assertFalse(res);

    }
    @Test
    void shouldBeTrueCauseHasNumber(){
        //given
        String pwd = "ICHBINLANGGENUGABERD8ASISTEGAL";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationLowerCase(pwd);
        //when
        assertFalse(res);

    }

    @Test
    void shouldBeFalseCauseNoSpecialCharacter(){
        //given
        String pwd = "ICHBINLANGGENUGABERDASISTEGAL";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationSpecialKey(pwd);
        //when
        assertFalse(res);

    }
    @Test
    void shouldBeTrueCauseHasSpecialKey(){
        //given
        String pwd = "ICHBINLANGGENUGABE!RDASISTEGAL";
        //then 
        boolean res = pwdValidationNoRegExp.pwdValidationSpecialKey(pwd);
        //when
        assertTrue(res);

    }

    @Test
    void shouldReturnOkay(){
        //given
        String pwd = "IchBin5owasVonSicher!";
        //then
        String res = pwdValidationNoRegExp.pwdValidNoRegExp(pwd);
        //when
        assertEquals("Okay", res);
    }

    @Test
    void NoSpecialChar(){
        //given
        String pwd = "IchBin5owasVonSichera";
        //then
        String res = pwdValidationNoRegExp.pwdValidNoRegExp(pwd);
        //when
        assertEquals("Passwörter müssen ein Sonderzeichen enthalten.", res);
    }

    @Test
    void NoNumber(){
        //given
        String pwd = "IchBinSowasVonSicher!";
        //then
        String res = pwdValidationNoRegExp.pwdValidNoRegExp(pwd);
        //when
        assertEquals("Passwörter müssen eine Zahl enthalten.", res);
    }

    @Test
    void NoUpperCase(){
        //given
        String pwd = "ichbinsowasvonsicher!";
        //then
        String res = pwdValidationNoRegExp.pwdValidNoRegExp(pwd);
        //when
        assertEquals("Passwörter müssen einen Großgeschriebenen Buchstaben enthalten.", res);
    }

    @Test
    void NoLowerCase(){
        //given
        String pwd = "ICHBINSOWASVONSICHER4!";
        //then
        String res = pwdValidationNoRegExp.pwdValidNoRegExp(pwd);
        //when
        assertEquals("Passwörter müssen einen kleingeschriebenen Buchstaben enthalten.", res);
    }


    



}

