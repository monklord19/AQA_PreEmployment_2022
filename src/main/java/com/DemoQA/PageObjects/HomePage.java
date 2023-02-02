package com.DemoQA.PageObjects;

import com.DemoQA.Utils.BrowserUtils;
import com.DemoQA.BaseClass;

public class HomePage extends BaseClass {

    private static String linkElementsButton  = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]";
    private static String linkWidgetsButton  = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]";



    public static void ClickElementsButton(){

        BrowserUtils.clickElement(linkElementsButton);
    }

    public static void ClickWidgetsButton(){

        BrowserUtils.clickElement(linkWidgetsButton);
    }












}
