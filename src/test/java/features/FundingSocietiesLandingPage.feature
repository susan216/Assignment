Feature: Validate

@LandingPage
Scenario Outline: Veirfy user navigates to Statistics page
Given User launches "<url>"
When User clicks Statistics button
Then Verify user is navigated to Statistics page

Examples:
|url|
|https://fundingsocieties.com/|

