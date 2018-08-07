Feature: Amazon Shopping
Scenario: User buys 5 items from site
Given user navigates to amazon
When user adds 5 items to cart
And user goes to cart and proceeds tpo checkout
Then user is navigated to payment page