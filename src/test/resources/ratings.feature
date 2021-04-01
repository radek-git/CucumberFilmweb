Feature: Ratings
  Background: User is logged
    Given User waits for RODO message and clicks RODO confirm button
    And User clicks Filmweb account login button
    And User loggs in using username="klint.istlud7@gmail.com" and password="Dupa22"

    Scenario Outline: User can rate movies
      When User clicks on Films button
      And User selects <movieNumber> movie
      And User ranks star <numberOfStars>
      And User clicks User button
      Then Movie has rating <numberOfStars>
      Examples:
        | movieNumber | numberOfStars |
        | 1           | 2             |
#        | 2           | 2             |
#        | 3           | 3             |
#        | 4           | 4             |
#        | 5           | 5             |
#        | 6           | 6             |
#        | 7           | 7             |
#        | 8           | 8             |
#        | 9           | 9             |
#        | 10          | 10            |
