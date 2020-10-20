Feature:User creates a line of credit


  Scenario: User creates a line of credit for $1000 and 35% APR.

    Given user on home page
    When user click on new credit line link
    And user enter APR "35" into input box
    And user enter "1000" of credit limit into input box
    When user clicks on new line of credit button
    Then user sees "Line of credit was successfully created." message
    And user sees APR  "Apr: 35.000%" is displayed
    And user sees credit available  "Credit Available: $1000.00 of $1,000.00" is displayed
    And user sees the correct "Credit Line Opened: October 19, 2020" date
    And user sees the Interest at 30 days is "Interest at 30 days: $0.00"
    And user sees Total Payoff at 30 days is "Total Payoff at 30 days: $0.00"
    When user choose operation "draw" and puts  amount "$500" on day "1"
    Then users remaining credit limit is "Credit Available: $500.00 of $1,000.00"
    And users balance is amount "$500.00"
    And users thirty days total payoff amount would be "Total Payoff at 30 days: $514.38"





