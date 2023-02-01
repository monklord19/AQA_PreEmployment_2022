package selenium.PageObjects;

import selenium.BaseClass;
import selenium.Utils.BrowserUtils;

public class HomePage extends BaseClass {

    private static String linkElementsButton  = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]";



    public static void ClickElementsButton(){

        BrowserUtils.clickElement(linkElementsButton);
    }












}
