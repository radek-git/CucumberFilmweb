Feature: Adding to Want to see movie list
  Background: User is logged
    Given User waits for RODO message and clicks RODO confirm button
    And User clicks Filmweb account login button
    And User loggs in using credentials
      | username                | password |
      | klint.istlud7@gmail.com | Dupa22   |

  Scenario: User can add movie to Want to see list 1
    When User moves to movie page
      | link                                                         |
      | https://www.filmweb.pl/film/Wierz%C4%99+w+Ciebie-2020-838602 |
    And User moves mouse to Want to see button
    And User wait for visibility Want to see eyes
    And User clicks item index=1
    And Message displayed on Want to see button is message="Interesuje mnie"
    And User clicks User page button
    Then Number of Want to see movies is wantToSeeMovies=1

#  Scenario: User can add movie to Want to see list 2
#    When User moves to movie page
#      | link                                                         |
#      | https://www.filmweb.pl/film/Zielona+mila-1999-862 |
#    And User moves mouse to Want to see button
#    And User wait for visibility Want to see eyes
#    And User clicks item index=2
#    And Message displayed on Want to see button is message="Kiedyś zobaczę"
#    And User clicks User page button
#    Then Number of Want to see movies is wantToSeeMovies=2
