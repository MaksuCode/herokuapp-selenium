package org.maksu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.maksu.pages.Inputs;

@Tag("regression")
@Tag("wip")
public class Test_Input extends BaseTest{

    @Test
    @Disabled("Due to bug on Inputs.checkInput() method.")
    public void set_string_value(){
        Inputs inputs = new Inputs(driver);
        inputs.setInput("EEEEMMM");
        Assertions.assertFalse(inputs.checkInput()
                , "Just numbers should have been accepted!");
    }

    @Test
    public void set_int_value(){
        Inputs inputs = new Inputs(driver);
        inputs.setInput("123456789");
        Assertions.assertTrue(inputs.checkInput()
                , "Given number is not shown!");
    }



}
