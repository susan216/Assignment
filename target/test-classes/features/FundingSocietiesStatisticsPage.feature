Feature: Validate Statistics page

@Statistics @Statistics_TotalFunded
Scenario Outline: Veirfy Total Funded Amount is displayed on Statistics page
Given User launches "<url>"
When User clicks Statistics button
And Verify user is navigated to Statistics page
Then Verify Total funded amount is displayed to the user
Examples:
|url|
|https://fundingsocieties.com/|


@Statistics @Statistics_NoOfFinancing
Scenario Outline: Veirfy No. of financing is displayed on Statistics page
Given User launches "<url>"
When User clicks Statistics button
And Verify user is navigated to Statistics page
Then Verify No. of financing is displayed to the user
Examples:
|url|
|https://fundingsocieties.com/|

@Statistics @Statistics_DefaultRate @dryRun
Scenario Outline: Veirfy Default rate is displayed on Statistics page
Given User launches "<url>"
When User clicks Statistics button
And Verify user is navigated to Statistics page
Then Verify Default rate is displayed to the user
Examples:
|url|
|https://fundingsocieties.com/|

@Statistics @Statistics_FulfilmentRate
Scenario Outline: Veirfy Fulfilment Rate is displayed on Statistics page
Given User launches "<url>"
When User clicks Statistics button
And Verify user is navigated to Statistics page
Then Verify Fulfilment Rate is displayed to the user
Examples:
|url|
|https://fundingsocieties.com/|

@Statistics @Statistics_Tabs
Scenario Outline: Veirfy General, Repayment, Disbursement tabs are displayed on Statistics page
Given User launches "<url>"
When User clicks Statistics button
And Verify user is navigated to Statistics page
Then Verify General Tab is displayed to the user
And Verify Repayment Tab is displayed to the user
And Verify Disbursement Tab is displayed to the user
Examples:
|url|
|https://fundingsocieties.com/|


@Statistics @Statistics_GeneralTab
Scenario Outline: Veirfy total approved loans, total amount disbursed and default rate are displayed under General Tab
Given User launches "<url>"
When User clicks Statistics button
And Verify user is navigated to Statistics page
Then Verify total approved loans is displayed to the user
And Verify total amount disbursed is displayed to the user
And Verify default rate is displayed to the user under General tab
Examples:
|url|
|https://fundingsocieties.com/|

@Statistics_RepaymentTab
Scenario Outline: Veirfy total repayment amount, principal amount and interest amount are displayed under Repayment Tab
Given User launches "<url>"
When User clicks Statistics button
And Verify user is navigated to Statistics page
Then Verify total repayment amount,principal amount and interest amount is displayed to the user

Examples:
|url|
|https://fundingsocieties.com/|


@Statistics @Statistics_DisbursementTab
Scenario Outline: Veirfy Disbursement tab and store all industry names according percentage
Given User launches "<url>"
When User clicks Statistics button
And Verify user is navigated to Statistics page
Then Verify Disbursement tab and store all industry names according percentage

Examples:
|url|
|https://fundingsocieties.com/|