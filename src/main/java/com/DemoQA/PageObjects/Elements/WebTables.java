package com.DemoQA.PageObjects.Elements;

import com.DemoQA.Utils.BrowserUtils;

public class WebTables {

    //Web Tables - Add New Record on the table - elements
    private static String ClickWebTablesButton = "//*[@id=\"item-3\"]/span";
    private static String ClickAddButton = "//*[@id=\"addNewRecordButton\"]";
    private static String AddFirstName = "//*[@id=\"firstName\"]";
    private static String AddLastName = "//*[@id=\"lastName\"]";
    private static String AddEmail = "//*[@id=\"userEmail\"]";
    private static String AddAge = "//*[@id=\"age\"]";
    private static String AddSalary = "//*[@id=\"salary\"]";
    private static String AddDepartment = "//*[@id=\"department\"]";
    private static String ClickSubmit = "//*[@id=\"submit\"]";
    private static String ClickEditButton = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[7]";
    private static String ClickDeleteButton = "//*[@id=\"delete-record-4\"]";
    private static String EditEmail = "//*[@id=\"userEmail\"]";
    private static String SubmitButtonOnEditFunction = "//*[@id=\"submit\"]";
    private static String EmptyRow = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div";



    //Web tables - Validate the new added records
    private static String ValidateFirstName = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]";
    private static String ValidateLastName = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[2]";
    private static String ValidateAge = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]";
    private static String ValidateEmail = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[4]";
    private static String ValidateSalary = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[5]";
    private static String ValidateDepartment = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[6]";
    private static String ValidateEmptyRow = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[6]";


    public static void ClickOnWebTablesButton(){
        BrowserUtils.clickElement(ClickWebTablesButton);
    }

    public static void ClickOnAddButton(){
        BrowserUtils.clickElement(ClickAddButton);
    }

    public static void AddTextFirstName(String FirstName){
        BrowserUtils.enterText(AddFirstName, FirstName);
    }

    public static void AddTextLastName(String LastName){
        BrowserUtils.enterText(AddLastName, LastName);
    }

    public static void AddTextEmail(String Email){
        BrowserUtils.enterText(AddEmail, Email);
    }

    public static void AddTextAge(String Age){
        BrowserUtils.enterText(AddAge, Age);
    }

    public static void AddTextSalary(String Salary){
        BrowserUtils.enterText(AddSalary, Salary);
    }

    public static void AddTextDepartment(String Department){
        BrowserUtils.enterText(AddDepartment, Department);
    }

    public static void ClickSubmitButton(){
        BrowserUtils.clickElement(ClickSubmit);
    }

    public static void FirstNameValidation(String expectedFirstName){
        BrowserUtils.validateText(ValidateFirstName, expectedFirstName);
    }

    public static void LastNameValidation(String expectedLastName){
        BrowserUtils.validateText(ValidateLastName, expectedLastName);
    }

    public static void AgeValidation(String expectedAge){
        BrowserUtils.validateText(ValidateAge, expectedAge);
    }

    public static void EmailValidation(String expectedEmail){
        BrowserUtils.validateText(ValidateEmail, expectedEmail);
    }

    public static void SalaryValidation(String expectedSalary){
        BrowserUtils.validateText(ValidateSalary, expectedSalary);
    }

    public static void DepartmentValidation(String expectedDepartment){
        BrowserUtils.validateText(ValidateDepartment, expectedDepartment);
    }

    public static void ClickOnEditButton(){
        BrowserUtils.clickElement(ClickEditButton);
    }

    public static void EditEmailField(String EditTheEmail){
        BrowserUtils.enterText(EditEmail, EditTheEmail);
    }

    public static void ClickSubmitOnEditAction(){
        BrowserUtils.clickElement(SubmitButtonOnEditFunction);
    }

    public static void ClickOnDeleteButton(){
        BrowserUtils.clickElement(ClickDeleteButton);
    }

    public static void ValidateEmptyRow(){
        BrowserUtils.getEmptyText(EmptyRow);
    }
}
