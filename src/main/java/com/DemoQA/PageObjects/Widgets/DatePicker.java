package com.DemoQA.PageObjects.Widgets;

import com.DemoQA.Utils.BrowserUtils;

public class DatePicker {

    private static String SelectDateButton = "//*[@id=\"datePickerMonthYearInput\"]";
    private static String Select15thFebruary= "//*[@id=\"datePickerMonthYearInput\"]";

    public static void ClickTextBoxButton(){
        BrowserUtils.clickElement(SelectDateButton);
    }
}
