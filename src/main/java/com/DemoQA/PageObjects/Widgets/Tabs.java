package com.DemoQA.PageObjects.Widgets;

import com.DemoQA.Utils.BrowserUtils;

public class Tabs {

    //Tabs - Web Elements
    private static String ClickTabsButton = "//*[text()='Tabs']";
    private static String ClickOriginButton = "//*[@id=\"demo-tab-origin\"]";


    //Tabs - Elements to be validated
    private static String ValidateClickOriginButton = "//*[@id=\"demo-tabpane-origin\"]";



    public static void ClickOnTabButton(){
        BrowserUtils.clickElement(ClickTabsButton);
    }

    public static void ClickOnOriginButton(){
        BrowserUtils.clickElement(ClickOriginButton);
    }

    public static void ValidateTheClickOnOriginTab(){
        BrowserUtils.getTextOriginTab(ValidateClickOriginButton);
    }
}
