package com.DemoQA.PageObjects.Elements;

import com.DemoQA.Utils.BrowserUtils;

public class Buttons {

    private static String ClickButtons = "//*[@id=\"item-4\"]/span";
    private static String ClickMeButton = "//*[contains(@id,'NqfBH')]";
    private static String DoubleClick = "//*[@id=\"doubleClickBtn\"]";

    private static String ClickMeResponse = "//*[@id=\"dynamicClickMessage\"]";
    private static String DoubleClickMeResponse = "//*[@id=\"doubleClickMessage\"]";

    public static void ClickButtonsElement() {
        BrowserUtils.clickElement(ClickButtons);
    }

    public static void ClickOnClickMe() {
        BrowserUtils.clickElement(ClickMeButton);
    }

    public static void DoubleClickButton() {
        BrowserUtils.clickElement(DoubleClick);
    }

    public static void ClickMeValidateResponseClickMe(String MessageResponse) {
        BrowserUtils.validateText(ClickMeResponse, MessageResponse);
    }

    public static void ValidateDoubleClickMe(String MessageResponse) {
        BrowserUtils.validateText(DoubleClickMeResponse, MessageResponse);
    }

}
