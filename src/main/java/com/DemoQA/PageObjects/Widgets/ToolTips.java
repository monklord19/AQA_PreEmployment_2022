package com.DemoQA.PageObjects.Widgets;

import com.DemoQA.BaseClass;
import com.DemoQA.Utils.BrowserUtils;

public class ToolTips extends BaseClass {

    private static String ClickToolTipsButton = "//*[@id=\"item-6\"]/span";
    private static String HooverContraryWord = "//*[@id=\"texToolTopContainer\"]/a[1]";


    public static void ClickToolTips(){
        BrowserUtils.clickElement(ClickToolTipsButton);
    }

    public static void HooverContrary(){
        BrowserUtils.hooverElement(HooverContraryWord);
    }
}
