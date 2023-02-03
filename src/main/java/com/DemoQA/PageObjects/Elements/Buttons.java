package com.DemoQA.PageObjects.Elements;

import com.DemoQA.Utils.BrowserUtils;

public class Buttons {

    private static String ClickButtons = "//*[@id=\"item-4\"]/span";
    private static String ClickMeButton = "//*[@id=\"3NBd0\"]";
    private static String ClickMeResponse = "//*[@id=\"dynamicClickMessage\"]";


    public static void ClickButtonsElement() {
        BrowserUtils.clickElement(ClickButtons);
    }

    public static void ClickOnClickMe() {
        BrowserUtils.clickElement(ClickMeButton);
    }

    public static void ClickMeValidateResponse(String MessageResponse) {
        BrowserUtils.validateText(ClickMeResponse, MessageResponse);
    }

}
