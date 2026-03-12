Feature: Valid Doodle Search
 
  Background:
    Given I am on the Doodle search page
 
  @ColorSearch
  Scenario: Search for a doodle using the color blue
    When I select the color(s) "blue" from the colors tab
    And I click the search button
    Then the first scenario image should be displayed
    And I attach a screenshot of the doodle to the extent report
 
  @TopicSearch
  Scenario: Search for a doodle using the topic arts
    When I select the topic "arts" from the Topics tab
    And I click the search button
    Then the second scenario image should be displayed
    And I attach a screenshot of the doodle to the extent report
 
  @KeywordSearch
  Scenario: Search for a doodle using the keyword music
    When I enter "music" in the search bar
    And I click on the tab
    Then the third scenario image should be displayed
    And I attach a screenshot of the doodle to the extent report
 
 