package com.DemoQA.PageObjects.Elements;

import com.DemoQA.BaseClass;
import com.DemoQA.Utils.BrowserUtils;

public class CheckBox extends BaseClass {

    //Check Box - Web Elements
    private static String linkCheckBoxButton = "//*[@id=\"item-1\"]/span";
    private static String HomeCheckBoxButton = "//*[@id=\"tree-node\"]/ol/li/span/label/span[3]";
    private static String ExpandCheckBoxList = "//*[@id=\"tree-node\"]/div/button[1]";
    private static String CommandsCheckBox = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]/svg/path";
    private static String AngularCheckBox = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[3]";
    private static String ClassifiedCheckBox = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[3]";

    //Radio Button - Elements to be validated
    private static String ValidateTextCheckBox = "//*[@id=\"result\"]/span[1]";


    public static void ClickCheckBoxButton(){
        BrowserUtils.clickElement(linkCheckBoxButton);
    }

    public static void ExpandCheckBoxList(){
        BrowserUtils.clickElement(ExpandCheckBoxList);
    }

    public static void CommandsCheckBox(){
        BrowserUtils.clickElement(CommandsCheckBox);
    }

    public static void AngularCheckBox(){
        BrowserUtils.clickElement(AngularCheckBox);
    }

    public static void ClassifiedCheckbox(){
        BrowserUtils.clickElement(ClassifiedCheckBox);
    }

    public static void ValidateTextCheckBox(String expectedText){
        BrowserUtils.validateText(ValidateTextCheckBox, expectedText);
    }

    public static void HomeCheckBoxButton(){
        BrowserUtils.clickElement(HomeCheckBoxButton);
    }


}
