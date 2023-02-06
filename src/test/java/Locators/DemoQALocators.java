package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DemoQALocators {

    WebDriver driver;

    public DemoQALocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // locators for #1 scenario
    public static final String ELEMENTSPATH_CLS = "card";
    public static final String TEXTBOX_CLS = "text";
    public static final String FULLNAME_ID = "userName";
    public static final String EMAIL_ID = "userEmail";
    public static final String CADDRESS_ID = "currentAddress";
    public static final String PADDRESS_ID = "permanentAddress";
    public static final String SUBMIT_XPATH = "//*[@id=\"submit\"]";
    public static final String OUTPUT_ID = "output";

    //locators for #2 scenario

    public static final String ALERTBUTTON_ID = "alertButton";
    public static final String TIMERBUTTON_ID = "timerAlertButton";
    public static final String CONFIRMBUTTON_ID = "confirmButton";
    public static final String PROMTBUTTON_ID = "promtButton";

    //locators for #3 scenario

    public static final String AFW_CSS = "div.body-height:nth-child(2) div.home-content div.home-body div.category-cards div.card.mt-4.top-card:nth-child(3) div:nth-child(1) div.avatar.mx-auto.white > svg:nth-child(1)\n";
    public static final String MODALDIALOGS_XPATH = "//*[@id=\"item-4\"]/span";
    public static final String SMALLTEXT_CLS = "modal-body";
    public static final String SMALLMODAL_ID = "showSmallModal";
    public static final String SMALLCONTENT_CLS = "modal-body";
    public static final String CLOSESMALLMODAL_ID = "closeSmallModal";
    public static final String LARGETEXT_CLS = "modal-body";
    public static final String LARGEMODAL_ID = "showLargeModal";
    public static final String LARGECONTENT_XPATH = "/html/body/div[4]/div/div/div[2]/p";
    public static final String CLOSELARGEMODAL_ID = "closeLargeModal";

    //locators for #4 scenrio

    public static final String DNUPATH_ID = "item-7";
    public static final String BROWSE_ID = "uploadFile";
    public static final String FILEPATH_ID = "uploadedFilePath";
    public static final String DOWNLOADBUTTON_ID = "downloadButton";

    //locators for #5 scenario

    public static final String HOVERBUTTON_ID = "toolTipButton";
    public static final String DISPLAYMESSAGE_CLS ="tooltip-inner";
    public static final String TOOLTIPETEXT_ID = "toolTipTextField";
    public static final String FIRSTTEXT_XPATH = "//*[@id=\"texToolTopContainer\"]/a[1]";
    public static final String SECONDTEXT_PATH = "//*[@id=\"texToolTopContainer\"]/a[2]";

    //locators for #6 scenario

    public static final String RESIZEBOX_XPATH = "//*[@id=\"resizableBoxWithRestriction\"]/span";
    public static final String SIZEBOX_XPATH = "//*[@id=\"resizableBoxWithRestriction\"]";
    public static final String MINSIZE_PATH = "//*[@id=\"resizableBoxWithRestriction\"]";
    public static final String MAXSIZE_PATH = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[1]";

    //locators for #7 scenario

    public static final String CURSORSTYLE_XPATH = "//*[@id=\"draggableExample-tab-cursorStyle\"]";
    public static final String CENTERBOX_ID = "cursorCenter";
    public static final String TOPLEFTBOX_ID = "cursorTopLeft";
    public static final String BOTTOMBOX_ID = "cursorBottom";

    //locators for #8 scenario

    public static final String SELECTDATE_ID = "datePickerMonthYearInput";
    public static final String SELECTDAY_XPATH = "//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[5]";
    public static final String SELECTMONTH_XPATH = "//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select";
    public static final String SELECTYEAR_XPATH = "//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select";

    //locators for #9 scenario

    public static final String AUTHOR_XPATH = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[3]";
    public static final String PUBLISHER_XPATH = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[4]/div[1]";
    public static final String SEARCHFOR_ID = "searchBox";
    public static final String INFORMATION_ID = "userName-value";
    public static final String CLICKPUBLISHER_XPATH = "//*[@id=\"see-book-Understanding ECMAScript 6\"]/a";
    public static final String CLICKAUTHOR_XPATH = "//*[@id=\"see-book-Speaking JavaScript\"]/a";
    public static final String BACKBUTTON_ID = "addNewRecordButton";
    public static final String PUB_XPATH = "//*[@id=\"userName-value\"]";
    public static final String UPDATESEARCH = "//*[@id=\"searchBox\"]";

    //locators for #10 scenario

    public static final String STARTSTOPBUTTON_ID = "startStopButton";
    public static final String PROGRESSBAR_ID = "progressBar";
    public static final String RESETBUTTON_ID = "resetButton";
    public static final String FULLPROGRESS_XPATH = "//*[@id=\"progressBar\"]/div";


    // #1
    @FindBy(className = DemoQALocators.ELEMENTSPATH_CLS)
    @CacheLookup
    private WebElement elementPath;

    @FindBy(className = DemoQALocators.TEXTBOX_CLS)
    @CacheLookup
    private WebElement textBox;

    @FindBy(id = DemoQALocators.FULLNAME_ID)
    @CacheLookup
    private WebElement fullName;

    @FindBy(id = DemoQALocators.EMAIL_ID)
    @CacheLookup
    private WebElement email;

    @FindBy(id = DemoQALocators.CADDRESS_ID)
    @CacheLookup
    private WebElement currentAddress;

    @FindBy(id = DemoQALocators.PADDRESS_ID)
    @CacheLookup
    private WebElement permanentAddress;

    @FindBy(xpath = DemoQALocators.SUBMIT_XPATH)
    @CacheLookup
    private WebElement submitButton;

    @FindBy(id = DemoQALocators.OUTPUT_ID)
    @CacheLookup
    private WebElement output;

    // #2
    @FindBy(id = DemoQALocators.ALERTBUTTON_ID)
    @CacheLookup
    private WebElement alertButton;

    @FindBy(id = DemoQALocators.CONFIRMBUTTON_ID)
    @CacheLookup
    private WebElement confirmButton;

    @FindBy(id = DemoQALocators.TIMERBUTTON_ID)
    @CacheLookup
    private WebElement timerButton;

    @FindBy(id = DemoQALocators.PROMTBUTTON_ID)
    @CacheLookup
    private WebElement promtButton;

    // #3
    @FindBy(css = DemoQALocators.AFW_CSS)
    @CacheLookup
    private WebElement afw;

    @FindBy(xpath = DemoQALocators.MODALDIALOGS_XPATH)
    @CacheLookup
    private WebElement modalDialogs;

    @FindBy(className = DemoQALocators.SMALLTEXT_CLS)
    @CacheLookup
    private WebElement smallText;

    @FindBy(id = DemoQALocators.SMALLMODAL_ID)
    @CacheLookup
    private WebElement smallModal;

    @FindBy(className = DemoQALocators.SMALLCONTENT_CLS)
    @CacheLookup
    private WebElement smallContent;

    @FindBy(id = DemoQALocators.CLOSESMALLMODAL_ID)
    @CacheLookup
    private WebElement closeSmallModal;

    @FindBy(className = DemoQALocators.LARGETEXT_CLS)
    @CacheLookup
    private WebElement largeText;

    @FindBy(id = DemoQALocators.LARGEMODAL_ID)
    @CacheLookup
    private WebElement largeModal;

    @FindBy(xpath = DemoQALocators.LARGECONTENT_XPATH)
    @CacheLookup
    private WebElement largeContent;

    @FindBy(id = DemoQALocators.CLOSELARGEMODAL_ID)
    @CacheLookup
    private WebElement closeLargeModal;

    // #4

    @FindBy(id = DemoQALocators.DNUPATH_ID)
    @CacheLookup
    private WebElement dnu;

    @FindBy(id = DemoQALocators.BROWSE_ID)
    @CacheLookup
    private WebElement browse;

    @FindBy(id = DemoQALocators.FILEPATH_ID)
    @CacheLookup
    private WebElement filePath;

    @FindBy(id = DemoQALocators.DOWNLOADBUTTON_ID)
    @CacheLookup
    private WebElement downloadButton;

    // #5

    @FindBy(id = DemoQALocators.HOVERBUTTON_ID)
    @CacheLookup
    private WebElement hoverButton;

    @FindBy(className = DemoQALocators.DISPLAYMESSAGE_CLS)
    @CacheLookup
    private WebElement displayMessage;

    @FindBy(id = DemoQALocators.TOOLTIPETEXT_ID)
    @CacheLookup
    private WebElement toolTipText;

    @FindBy(className = DemoQALocators.DISPLAYMESSAGE_CLS)
    @CacheLookup
    private WebElement message;

    @FindBy(xpath = DemoQALocators.FIRSTTEXT_XPATH)
    @CacheLookup
    private WebElement firstText;

    @FindBy(xpath = DemoQALocators.SECONDTEXT_PATH)
    @CacheLookup
    private WebElement secondText;

    // #6

    @FindBy(xpath = DemoQALocators.RESIZEBOX_XPATH)
    @CacheLookup
    private WebElement resizeBox;

    @FindBy(xpath = DemoQALocators.SIZEBOX_XPATH)
    @CacheLookup
    private WebElement sizeBox;

    @FindBy(xpath = DemoQALocators.MINSIZE_PATH)
    @CacheLookup
    private WebElement minPath;

    @FindBy(xpath = DemoQALocators.MAXSIZE_PATH)
    @CacheLookup
    private WebElement maxPath;

    // #7

    @FindBy(id = DemoQALocators.CENTERBOX_ID)
    @CacheLookup
    private WebElement centerBox;
    @FindBy(id = DemoQALocators.TOPLEFTBOX_ID)
    @CacheLookup
    private WebElement topLeftBox;
    @FindBy(id = DemoQALocators.BOTTOMBOX_ID)
    @CacheLookup
    private WebElement bottomBox;
    @FindBy(xpath = DemoQALocators.CURSORSTYLE_XPATH)
    @CacheLookup
    private WebElement cursorStyle;

    //#8

    @FindBy(id = DemoQALocators.SELECTDATE_ID)
    @CacheLookup
    private WebElement selectDate;
    @FindBy(xpath = DemoQALocators.SELECTDAY_XPATH)
    @CacheLookup
    private WebElement selectDay;
    @FindBy(xpath = DemoQALocators.SELECTMONTH_XPATH)
    @CacheLookup
    private WebElement selectMonth;
    @FindBy(xpath = DemoQALocators.SELECTYEAR_XPATH)
    @CacheLookup
    private WebElement selectYear;

    // #9

    @FindBy(xpath = DemoQALocators.AUTHOR_XPATH)
    @CacheLookup
    private WebElement author;
    @FindBy(xpath = DemoQALocators.PUBLISHER_XPATH)
    @CacheLookup
    private WebElement publisher;
    @FindBy(id = DemoQALocators.SEARCHFOR_ID)
    @CacheLookup
    private WebElement searchFor;
    @FindBy(id = DemoQALocators.INFORMATION_ID)
    @CacheLookup
    private WebElement information;
    @FindBy(xpath = DemoQALocators.CLICKPUBLISHER_XPATH)
    @CacheLookup
    private WebElement clickPublisher;
    @FindBy(xpath = DemoQALocators.CLICKAUTHOR_XPATH)
    @CacheLookup
    private WebElement clickAuthor;
    @FindBy(id = DemoQALocators.BACKBUTTON_ID)
    @CacheLookup
    private WebElement backButton;
    @FindBy(xpath = DemoQALocators.PUB_XPATH)
    @CacheLookup
    private WebElement pub;
    @FindBy(xpath = DemoQALocators.UPDATESEARCH)
    @CacheLookup
    private WebElement updateSearch;

    // #10
    @FindBy(id = DemoQALocators.STARTSTOPBUTTON_ID)
    @CacheLookup
    private WebElement startStop;
    @FindBy(id = DemoQALocators.PROGRESSBAR_ID)
    @CacheLookup
    private WebElement progressBar;
    @FindBy(id = DemoQALocators.RESETBUTTON_ID)
    @CacheLookup
    private WebElement resetButton;
    @FindBy(xpath = DemoQALocators.FULLPROGRESS_XPATH)
    @CacheLookup
    private WebElement fullProgress;


    // getters and setters for #1 scenario
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElementPath() {
        return elementPath;
    }

    public void setElementPath(WebElement elementPath) {
        this.elementPath = elementPath;
    }

    public WebElement getTextBox() {
        return textBox;
    }

    public void setTextBox(WebElement textBox) {
        this.textBox = textBox;
    }

    public WebElement getFullName() {
        return fullName;
    }

    public void setFullName(WebElement fullName) {
        this.fullName = fullName;
    }

    public WebElement getEmail() {
        return email;
    }

    public void setEmail(WebElement email) {
        this.email = email;
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(WebElement currentAddress) {
        this.currentAddress = currentAddress;
    }

    public WebElement getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(WebElement permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }
    public WebElement getOutput() {
        return output;
    }

    public void setOutput(WebElement output) {
        this.output = output;
    }

    //getters and setters for #2 scenario


    public WebElement getAlertButton() {
        return alertButton;
    }

    public void setAlertButton(WebElement alertButton) {
        this.alertButton = alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(WebElement confirmButton) {
        this.confirmButton = confirmButton;
    }

    public WebElement getTimerButton() {
        return timerButton;
    }

    public void setTimerButton(WebElement timerButton) {
        this.timerButton = timerButton;
    }

    public WebElement getPromtButton() {
        return promtButton;
    }

    public void setPromtButton(WebElement promtButton) {
        this.promtButton = promtButton;
    }

    //getters and seters for #3 scenario


    public WebElement getAfw() {
        return afw;
    }

    public void setAfw(WebElement afw) {
        this.afw = afw;
    }

    public WebElement getModalDialogs() {
        return modalDialogs;
    }

    public void setModalDialogs(WebElement modalDialogs) {
        this.modalDialogs = modalDialogs;
    }

    public WebElement getSmallText() {
        return smallText;
    }

    public void setSmallText(WebElement smallText) {
        this.smallText = smallText;
    }

    public WebElement getSmallModal() {
        return smallModal;
    }

    public void setSmallModal(WebElement smallModal) {
        this.smallModal = smallModal;
    }

    public WebElement getSmallContent() {
        return smallContent;
    }

    public void setSmallContent(WebElement smallContent) {
        this.smallContent = smallContent;
    }

    public WebElement getCloseSmallModal() {
        return closeSmallModal;
    }

    public void setCloseSmallModal(WebElement closeSmallModal) {
        this.closeSmallModal = closeSmallModal;
    }

    public WebElement getLargeText() {
        return largeText;
    }

    public void setLargeText(WebElement largeText) {
        this.largeText = largeText;
    }

    public WebElement getLargeModal() {
        return largeModal;
    }

    public void setLargeModal(WebElement largeModal) {
        this.largeModal = largeModal;
    }

    public WebElement getLargeContent() {
        return largeContent;
    }

    public void setLargeContent(WebElement largeContent) {
        this.largeContent = largeContent;
    }

    public WebElement getCloseLargeModal() {
        return closeLargeModal;
    }

    public void setCloseLargeModal(WebElement closeLargeModal) {
        this.closeLargeModal = closeLargeModal;
    }

    //getters and setters for #4


    public WebElement getDnu() {
        return dnu;
    }

    public void setDnu(WebElement dnu) {
        this.dnu = dnu;
    }

    public WebElement getBrowse() {
        return browse;
    }

    public void setBrowse(WebElement browse) {
        this.browse = browse;
    }

    public WebElement getFilePath() {
        return filePath;
    }

    public void setFilePath(WebElement filePath) {
        this.filePath = filePath;
    }

    public WebElement getDownloadButton() {
        return downloadButton;
    }

    public void setDownloadButton(WebElement downloadButton) {
        this.downloadButton = downloadButton;
    }

    //getters and setters for #5 scenario


    public WebElement getHoverButton() {
        return hoverButton;
    }

    public void setHoverButton(WebElement hoverButton) {
        this.hoverButton = hoverButton;
    }

    public WebElement getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(WebElement displayMessage) {
        this.displayMessage = displayMessage;
    }

    public WebElement getToolTipText() {
        return toolTipText;
    }

    public void setToolTipText(WebElement toolTipText) {
        this.toolTipText = toolTipText;
    }

    public WebElement getMessage() {
        return message;
    }

    public void setMessage(WebElement message) {
        this.message = message;
    }

    public WebElement getFirstText() {
        return firstText;
    }

    public void setFirstText(WebElement firstText) {
        this.firstText = firstText;
    }

    public WebElement getSecondText() {
        return secondText;
    }

    public void setSecondText(WebElement secondText) {
        this.secondText = secondText;
    }

    // getters and setters for #6 scenario


    public WebElement getResizeBox() {
        return resizeBox;
    }

    public void setResizeBox(WebElement resizeBox) {
        this.resizeBox = resizeBox;
    }

    public WebElement getSizeBox() {
        return sizeBox;
    }

    public void setSizeBox(WebElement sizeBox) {
        this.sizeBox = sizeBox;
    }

    public WebElement getMinPath() {
        return minPath;
    }

    public void setMinPath(WebElement minPath) {
        this.minPath = minPath;
    }

    public WebElement getMaxPath() {
        return maxPath;
    }

    public void setMaxPath(WebElement maxPath) {
        this.maxPath = maxPath;
    }

    //getters and setters for #7 scenario


    public WebElement getCenterBox() {
        return centerBox;
    }

    public void setCenterBox(WebElement centerBox) {
        this.centerBox = centerBox;
    }

    public WebElement getTopLeftBox() {
        return topLeftBox;
    }

    public void setTopLeftBox(WebElement topLeftBox) {
        this.topLeftBox = topLeftBox;
    }

    public WebElement getBottomBox() {
        return bottomBox;
    }

    public void setBottomBox(WebElement bottomBox) {
        this.bottomBox = bottomBox;
    }

    public WebElement getCursorStyle() {
        return cursorStyle;
    }

    public void setCursorStyle(WebElement cursorStyle) {
        this.cursorStyle = cursorStyle;
    }

    //getters and setters for #8 scenario


    public WebElement getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(WebElement selectDate) {
        this.selectDate = selectDate;
    }

    public WebElement getSelectDay() {
        return selectDay;
    }

    public void setSelectDay(WebElement selectDay) {
        this.selectDay = selectDay;
    }

    public WebElement getSelectMonth() {
        return selectMonth;
    }

    public void setSelectMonth(WebElement selectMonth) {
        this.selectMonth = selectMonth;
    }

    public WebElement getSelectYear() {
        return selectYear;
    }

    public void setSelectYear(WebElement selectYear) {
        this.selectYear = selectYear;
    }

    //getters and setters for #9 scenario


    public WebElement getAuthor() {
        return author;
    }

    public void setAuthor(WebElement author) {
        this.author = author;
    }

    public WebElement getPublisher() {
        return publisher;
    }

    public void setPublisher(WebElement publisher) {
        this.publisher = publisher;
    }

    public WebElement getSearchFor() {
        return searchFor;
    }

    public void setSearchFor(WebElement searchFor) {
        this.searchFor = searchFor;
    }

    public WebElement getInformation() {
        return information;
    }

    public void setInformation(WebElement information) {
        this.information = information;
    }

    public WebElement getClickPublisher() {
        return clickPublisher;
    }

    public void setClickPublisher(WebElement clickPublisher) {
        this.clickPublisher = clickPublisher;
    }

    public WebElement getClickAuthor() {
        return clickAuthor;
    }

    public void setClickAuthor(WebElement clickAuthor) {
        this.clickAuthor = clickAuthor;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public void setBackButton(WebElement backButton) {
        this.backButton = backButton;
    }

    public WebElement getPub() {
        return pub;
    }

    public void setPub(WebElement pub) {
        this.pub = pub;
    }

    public WebElement getUpdateSearch() {
        return updateSearch;
    }

    public void setUpdateSearch(WebElement updateSearch) {
        this.updateSearch = updateSearch;
    }

    //getters and setters for #10 scenerio

    public WebElement getStartStop() {
        return startStop;
    }

    public void setStartStop(WebElement startStop) {
        this.startStop = startStop;
    }

    public WebElement getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(WebElement progressBar) {
        this.progressBar = progressBar;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public void setResetButton(WebElement resetButton) {
        this.resetButton = resetButton;
    }

    public WebElement getFullProgress() {
        return fullProgress;
    }

    public void setFullProgress(WebElement fullProgress) {
        this.fullProgress = fullProgress;
    }
}
