package selenium.PageObjects;

import selenium.BaseClass;
import selenium.Utils.BrowserUtils;

public class ElementsPage extends BaseClass {

    private static String linkRadioButton = "//*[@id=\"item-2\"]/span";
    private static String YesRadioElement = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label";
    private static String TextYesOptionOnRadioButton = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p";

    public static void ClickRadioButton(){
        BrowserUtils.clickElement(linkRadioButton);
    }

    public static void ClickYesOnRadioButton(){
        BrowserUtils.clickElement(YesRadioElement);
    }

    public static void ValidateYesOptionOnRadioButton(String expectedText){
        BrowserUtils.validateText(TextYesOptionOnRadioButton, expectedText);
    }

}
