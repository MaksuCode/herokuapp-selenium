package org.maksu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.maksu.pages.Checkboxes;

@Tag("regression")
public class Test_Checkboxes extends BaseTest{

    @Test
    public void click_check_box_1(){
        Checkboxes checkbox = new Checkboxes(driver);
        checkbox.clickCheckbox(0);
        Assertions.assertTrue(checkbox.isSelected(checkbox.getCheckboxList().get(0)),
                "Checkbox is not checked!");
    }

    @Test
    public void click_check_box_2(){
        Checkboxes checkbox = new Checkboxes(driver);
        checkbox.clickCheckbox(1);
        Assertions.assertFalse(checkbox.isSelected(checkbox.getCheckboxList().get(1)),
                "Checkbox is not checked!");
    }

}
