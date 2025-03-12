Feature: Car search

  Scenario: Valid login
  Given User opens the main page
  When User selects car category search
  When User selects the type of chassis
  Then User should be redirected to the dashboard
