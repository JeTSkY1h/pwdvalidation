package com.kim;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    void shouldAnswerWithFalseBecausePwdisLongerThen8ButhasNoNumber(){
        //given
        String pwd = "ichbinlangGenug";
        //when
        boolean res = App.pwdValid(pwd);
        //then
        assertFalse(res);
    }

    @Test 
    void shouldBeFalseBecausePwdHasNoSpecialChrakter() {
        //given
        String pwd = "ichbinlanASdggenug8";
        //when
        boolean res = App.pwdValid(pwd);
        //then
        assertFalse(res);
    }

    @Test
    void shouldBeFalseBecausePwdHasNoUpperCaseLetter() {
        //given
        String pwd = "asdasda!sdasdasdadsfe8";
        //when
        boolean res = App.pwdValid(pwd);
        //then
        assertFalse(res);
    }

    @Test
    void shouldBeTrueBecausePwdIsLongEnoughHasUpperCaseLetterNumberAndSpecialCharakter(){
        //given
        String pwd = "BeiMirIstAllesRichtig!!!111elf";
        //when
        boolean res = App.pwdValid(pwd);
        //then
        assertTrue(res);
    }

}
