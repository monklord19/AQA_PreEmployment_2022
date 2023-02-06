Feature: Testing items of the Elements menu

  Scenario:  Testing text box

    Given On the Elements page
    When I select the Text Box element
    And I enter text in the Full name, Email, Current Address and Permanent Address fields
    And I click Submit
    Then The data entered is displayed below the form

  Scenario:  Testing radio buttons

    Given On the Elements page
    When I select the Radio Button item
    And I select Yes
    Then Yes is selected and Impressive is unselected and No is disabled

  Scenario:  Testing check boxes

    Given On the Elements page
    When I select the Check Box item
    And I click Expand All button
    And I select the Home check box
    Then All check boxes in the list are selected

  Scenario:  Testing Click me button

    Given On the Elements page
    When I select the Buttons item
    And I click Click Me
    Then The validation text is displayed

  Scenario:  Testing Right Click Me button

    Given On the Elements page
    When I select the Buttons item
    And I click Right Click Me
    Then The right click validation text is displayed


  Scenario:  Testing dynamic home link

    Given On the Elements page
    When I select the Links item
    And I click the Home dynamic link
    Then The demoqa page opens in a new tab
