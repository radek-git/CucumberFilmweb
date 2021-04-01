Feature: User logs in
  Scenario: When user inputs correct credentials then he is logged
    Given User waits for RODO message and clicks RODO confirm button
    And User clicks Filmweb account login button
    And User inputs username and password
      | username                | password |
      | klint.istlud7@gmail.com | Dupa22   |

    When User clicks Submit button
    Then User is logged in

    Scenario: User inputs wrong credentials then error massage is displayed
      Given User waits for RODO message and clicks RODO confirm button
      And User clicks Filmweb account login button
      And User inputs username and password
        | username                | password |
        | dupa@gmail.com          | dupa   |

      When User clicks Submit button
      Then Error message is displayed
