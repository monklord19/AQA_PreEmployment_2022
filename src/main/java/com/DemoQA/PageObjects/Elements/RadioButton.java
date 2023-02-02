package com.DemoQA.PageObjects.Elements;

import com.DemoQA.BaseClass;
import com.DemoQA.Utils.BrowserUtils;

public class RadioButton extends BaseClass {

    //Radio Button - Fields to be completed
    private static String linkRadioButton = "//*[@id=\"item-2\"]/span";
    private static String YesRadioElement = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label";

    //Radio Button - Fields to be validated
    private static String TextYesOptionOnRadioButton = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p";


    public static void ClickRadioButton(){
        BrowserUtils.clickElement(linkRadioButton);
    }

    public static void ClickYesOnRadioButton(){
        BrowserUtils.clickElement(YesRadioElement);
    }

    public static void ValidateYesOptionOnRadioButton(String expectedText){
        BrowserUtils.validateText(TextYesOptionOnRadioButton, expectedText);
    }
}
