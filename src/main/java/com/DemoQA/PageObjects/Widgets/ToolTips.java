package com.DemoQA.PageObjects.Widgets;

import com.DemoQA.BaseClass;
import com.DemoQA.Utils.BrowserUtils;

public class ToolTips extends BaseClass {

    private static String ClickToolTipsButton = "//*[text()='Tool Tips']";
    private static String HooverContraryWord = "//*[@id=\"texToolTopContainer\"]/a[1]";
    private static String ResponseHooverContraryWord = "//*[@class='fade show tooltip bs-tooltip-bottom']";



    public static void ClickToolTips(){
        BrowserUtils.clickElement(ClickToolTipsButton);
    }

    public static void HooverContrary(){
        BrowserUtils.hooverElement(HooverContraryWord);
    }
}
