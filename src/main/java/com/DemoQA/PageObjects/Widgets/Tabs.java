package com.DemoQA.PageObjects.Widgets;

import com.DemoQA.Utils.BrowserUtils;

public class Tabs {
    private static String ClickTabsButton = "//*[text()='Tabs']";
    private static String ClickOriginButton = "//*[@id=\"demo-tab-origin\"]";


    public static void ClickOnTabButton(){
        BrowserUtils.clickElement(ClickTabsButton);
    }

    public static void ClickOnOriginButton(){
        BrowserUtils.clickElement(ClickOriginButton);
    }
}
