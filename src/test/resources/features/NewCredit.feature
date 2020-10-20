Feature:User creates a line of credit

  Background:
    Given user on home page
    When user click on new credit line link


  Scenario: User creates a line of credit for $1000 and 35% APR.
    #They draws $500 on day one so their remaining credit limit is $500 and their balance is $500.
      # They keep the money drawn for 30 days.
        # They should owe $500 * 0.35 / 365 * 30 = 14.38$ worth of interest on day 30.
          # Total payoff amount would be $514.38


    When user enter APR "35" into input box
    And user enter "1000" of credit limit into input box
    When user clicks on new line of credit button
    Then user sees "Line of credit was successfully created." message
    And user sees APR  "Apr: 35.000%" is displayed
    And user sees credit available  "Credit Available: $1000.00 of $1,000.00" is displayed
    And user sees the correct "Credit Line Opened: " date
    And user sees the Interest at 30 days is "Interest at 30 days: $0.00"
    And user sees Total Payoff at 30 days is "Total Payoff at 30 days: $0.00"
    When user choose operation "Draw" and puts  amount "500" on day "1"
    Then users remaining credit limit is "Credit Available: $500.00 of $1,000.00"
    And users balance is amount "$500.00"
    And users thirty days total payoff amount would be "Total Payoff at 30 days: $514.38"

  Scenario:   User creates a line of credit for $1000 and 35% APR (Scenario2)
      ##They draw $500 on day one so their remaining credit limit is $500 and their balance is $500.
      # They pay back $200 on day 15 and then draws another 100$ on day 25.
      # Their total owed interest on day 30 should be
      # 500 * 0.35 / 365 * 15 + 300 * 0.35 / 365 * 10 + 400 * 0.35 / 365 * 5 which is 11.99.
      # Total payment should be $411.99.

    When user enter APR "35" into input box
    And user enter "1000" of credit limit into input box
    When user clicks on new line of credit button
    Then user sees "Line of credit was successfully created." message
    And user sees APR  "Apr: 35.000%" is displayed
    And user sees credit available  "Credit Available: $1000.00 of $1,000.00" is displayed
    And user sees the correct "Credit Line Opened: " date
    And user sees the Interest at 30 days is "Interest at 30 days: $0.00"
    And user sees Total Payoff at 30 days is "Total Payoff at 30 days: $0.00"
    When user choose operation "Draw" and puts  amount "$500" on day "1"
    Then users remaining credit limit is "Credit Available: $500.00 of $1,000.00"
    And users balance is amount "$500.00"
    When user pay back "Payment" "200" on day "15"
    And  user choose operation "Draw" and puts  amount "100" on day "25"
    And users thirty days total payoff amount would be "Total Payoff at 30 days: $411.99"

  Scenario Outline: user user tries to break the system

    When user enter APR "<APR>" into input box
    And user enter "<amount>" of credit limit into input box
    When user clicks on new line of credit button
    Then user sees error "<message>" message
    Examples:
      | APR      | amount    | message                                           |
      | -35      | 1000      | Apr must be greater than or equal to 0.0          |
      | -1000    | 1000      | Apr must be greater than or equal to 0.0          |
      | -99      | 1000      | Apr must be greater than or equal to 0.0          |
      | 23       | -1000     | Credit limit must be greater than or equal to 0.0 |
      | @        | 1000      | Apr is not a number                               |
      | hgfhs    | 1000      | Apr is not a number                               |
      | 1hgfhs   | 1000      | Apr is not a number                               |
      | 1hgfhs2  | 1000      | Apr is not a number                               |
      | 35       | 1000ef    | Credit limit is not a number                      |
      | 35       | ewr1000ef | Credit limit is not a number                      |
      | 35       | ewr1000ef | Credit limit is not a number                      |
      | 35       | @         | Credit limit is not a number                      |
      | 4.87e+35 | 10000o    | Credit limit is not a number                      |
      | 4.87e+45 | 10000o    | Credit limit is not a number                      |
      | 4.87e+90 | 10000o    | Credit limit is not a number                      |
      | 35       | 4.67e+56  | Credit limit is not a number                      |
      | 35       | 4.67e+96  | Credit limit is not a number                      |
      | 35       | 3.67e+67  | Credit limit is not a number                      |








