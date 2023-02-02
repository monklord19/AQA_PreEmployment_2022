package com.DemoQA.PageObjects.Widgets;

import com.DemoQA.Utils.BrowserUtils;

public class Accordion {

    private static String ClickAccordionButton = "//*[@id=\"item-0\"]";
    private static String WhyDoWeUseItAccordion = "//*[@id=\"section3Heading\"]";



    public static void ClickAccordion(){
        BrowserUtils.clickElement(ClickAccordionButton);
    }

    public static void ClickWhyDoWeUSeIt(){
        BrowserUtils.clickElement(WhyDoWeUseItAccordion);
    }
}
