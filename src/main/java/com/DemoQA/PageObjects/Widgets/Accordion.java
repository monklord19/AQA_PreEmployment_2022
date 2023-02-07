package com.DemoQA.PageObjects.Widgets;

import com.DemoQA.Utils.BrowserUtils;

public class Accordion {

    //Accordion - Web Elements
    private static String ClickAccordionButton = "//*[text()='Accordian']";
    private static String WhyDoWeUseItAccordion = "//*[@id=\"section3Heading\"]";


    //Accordion - Elements to be validated
    private static String ResponseWhyDoWeUseItAccordion = "//*[@id=\"accordianContainer\"]/div/div[3]/div[2]";



    public static void ClickAccordion(){
        BrowserUtils.clickElement(ClickAccordionButton);
    }

    public static void ClickWhyDoWeUSeIt(){
        BrowserUtils.clickElement(WhyDoWeUseItAccordion);
    }

    public static void ValidateWhyDoWeUseItAccordion(){
        BrowserUtils.getTextAccordian(ResponseWhyDoWeUseItAccordion);
    }
}
