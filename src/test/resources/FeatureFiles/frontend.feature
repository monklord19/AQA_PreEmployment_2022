Feature:

  Background:
    Given I open the demoqa website

  @TextBox
  Scenario: Test if text box is working
    Given I go on the Elements page
    Given I go on the Text Box page
    When I insert my informations in the text box and i press submit button
    Then The informations should be displayed

  @ImpressiveRadioButtonClick
  Scenario: VerifyImpressiveRadioButton
    When I go on the Elements page
    When I go on the radioButton page
    And I click on the impressive button
    Then I shoud see the message "Impressive"

  @YesRadioButtonClick
  Scenario: VerifyYesRadioButton
    When I go on the Elements page
    When I go on the radioButton page
    And I click on the Yes button
    Then I shoud see the message "Yes"

  @DoubleClickButton
  Scenario: Perform double click button
    When I go on the Elements page
    When I go on the buttons page
    And I double click the button
    Then I should see the message for double click "You have done a double click"

  @RightClickButton
  Scenario: Perform right click button
    When I go on the Elements page
    When I go on the buttons page
    And I right click the button
    Then I should see the message for right click "You have done a right click"

  @DynamicClickButton
  Scenario: Perform single click button
    When I go on the Elements page
    When I go on the buttons page
    And I single click the button
    Then I should see the message for dynamic click "You have done a dynamic click"

  @ColorChange
  Scenario: Perform click and test if color change
    When I go on the Elements page
    When I go on the Dynamic Properties page
    Then I click the color change button and the colour should be changed

  @UploadButton
  Scenario: Test if upload button work
    Given I go on the Elements page
    Given I go on Update and Download page
    When I upload the file
    Then The file should be uploaded

  @ClickButtonToSeeAlert
  Scenario: Verify if alert button works
    When I go to Alerts,Frame,Windows page
    When I go on the alerts page
    And I click on button
    Then An alert should be displayed with the text "You clicked a button"
    And After i press ok button the pop up should close

  @NewTabOpened
  Scenario: Verify if Button open a new tab
    Given I go to Alerts,Frame,Windows page
    When I go on Browser Windows
    Then I click new tab button and a new tag should be opened

  @NewWindowOpened
  Scenario: Verify if Button open a new window
    Given I go to Alerts,Frame,Windows page
    When I go on Browser Windows
    Then I click new window button and a new window should be opened

  @ProgressBar
  Scenario: Test if progress bar works
    Given I go to Widgets button
    When I go on Progress Bar Page
    Then I press start button and the progress bar should change its value

  @Slider
  Scenario: Test if slider work
    Given I go to Widgets button
    Given I go on Slider Page
    When I use slide bar
    Then The slide value should change

  @Droppable
  Scenario: Test droppable
    Given I go on the Interactions page
    Given I go on the Droppable page
    When I perform drag and drop
    Then The item should be dropped and the text "Dropped!"should appear

  @Dragabble
  Scenario: Test dragabble
    Given I go on the Interactions page
    Given I go on the Dragabble page
    When  I drag an element it should change its position