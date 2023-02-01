package selenium.PageObjects;

import selenium.BaseClass;
import selenium.Utils.BrowserUtils;

public class HomePage extends BaseClass {

    private static String linkElementsButton  = "/html/body/div[2]/div/div/div[2]/div/div[1]/div/div[2]/svg";
    private static String linkRadioButton = "//*[@id=\"item-2\"]/span";

    public static void ClickElementsButton(){
        BrowserUtils.clickElement(linkElementsButton);
    }

    public static void ClickRadioButton(){
        BrowserUtils.clickElement(linkRadioButton);
    }








}
