package com.DemoQA.PageObjects.Elements;

import com.DemoQA.Utils.BrowserUtils;

public class Links {

    //Links - Web Elements
    private static String clickLinks = "//*[@id=\"item-5\"]";
    private static String MovedLink = "//*[@id=\"moved\"]";
    private static String ValidateTextMovedLink = "//*[@id=\"linkResponse\"]";

    public static void ClickLinks(){
        BrowserUtils.clickElement(clickLinks);
    }

    public static void ClickMovedLink(){
        BrowserUtils.clickElement(MovedLink);
    }

    public static void ValidateTextforMovedLink(String expectedText){
        BrowserUtils.validateText(ValidateTextMovedLink, expectedText);
    }
}
