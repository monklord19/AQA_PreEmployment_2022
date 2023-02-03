package com.DemoQA.PageObjects.Elements;

import com.DemoQA.Utils.BrowserUtils;

public class TextBox {

    //Text Box - Web Elements
    private static String TextBoxButton = "//*[@id=\"item-0\"]/span";
    private static String FullNameTextBox = "//*[@id=\"userName\"]";
    private static String EmailTextBox = "//*[@id=\"userEmail\"]";
    private static String CurrentAddressTextBox = "//*[@id=\"currentAddress\"]";
    private static String PermanentAddressTextBox = "//*[@id=\"permanentAddress\"]";
    private static String SubmitTextBox = "//*[@id=\"submit\"]";

    //Text Box - Elements to be validated
    private static String ValidateFullName = "//*[@id=\"name\"]";
    private static String ValidateEmail = "//*[@id=\"email\"]";
    private static String ValidateCurrentAddress = "//*[@id=\"currentAddress\"]";
    private static String ValidatePermanentAddress = "//*[@id=\"permanentAddress\"]";
    private static String ValidateResponseScenarioOutline = "//*[@id=\\\"output\\\"]\"";




    public static void ClickTextBoxButton(){
        BrowserUtils.clickElement(TextBoxButton);
    }

    public static void EnterFullName(String FullName){
        BrowserUtils.enterText(FullNameTextBox,FullName);
    }

    public static void EnterEmail(String Email){
        BrowserUtils.enterText(EmailTextBox,Email);
    }

    public static void EnterCurrentAddress(String CurrentAddress){
        BrowserUtils.enterText(CurrentAddressTextBox,CurrentAddress);
    }

    public static void EnterPermanentAddress(String PermanentAddress){
        BrowserUtils.enterText(PermanentAddressTextBox,PermanentAddress);
    }

    public static void ClickSubmitTextBox(){

        BrowserUtils.clickElement(SubmitTextBox);
    }

    public static void ValidateFullName(String expectedFullName){
        BrowserUtils.validateText(ValidateFullName, expectedFullName);
    }

    public static void ValidateEmail(String expectedEmail){

        BrowserUtils.validateText(ValidateEmail, expectedEmail);
    }

    public static void ValidateCurrentAddress(String expectedCurrentAddress){
        BrowserUtils.validateText(ValidateCurrentAddress, expectedCurrentAddress);
    }

    public static void ValidatePermanentAddress(String expectedPermanentAddress){
        BrowserUtils.validateText(ValidatePermanentAddress, expectedPermanentAddress);
    }

    public static void ValidateResponseScenarioOutline(){
        BrowserUtils.validateResponseScenarioOutline(ValidateResponseScenarioOutline);
    }

}
