package org.maksu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.maksu.pages.Inputs;

public class Test_Input extends BaseTest{

    @Test
    @Disabled("Disabled due to bug on line 24 : Input.class")
    public void set_string_value(){
        Inputs inputs = new Inputs(driver);
        inputs.setInput("EEEM");
        Assertions.assertTrue(inputs.checkInput() ,
                "Just numbers should have been accepted!");
    }



}
