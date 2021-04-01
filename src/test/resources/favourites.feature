Feature: Adding to favourites
  Background: User is logged
    Given User waits for RODO message and clicks RODO confirm button
    And User clicks Filmweb account login button
    And User loggs in using credentials
      | username                | password |
      | klint.istlud7@gmail.com | Dupa22   |


  Scenario: User can add movie to favourites
    When User moves to movie page
      | link                                                         |
      | https://www.filmweb.pl/film/Wierz%C4%99+w+Ciebie-2020-838602 |
    And User clicks favourite icon
    Then Movies are in favourites
      | title           |
      | Wierzę w Ciebie |

