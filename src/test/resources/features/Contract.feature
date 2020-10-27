@smoke_test
Feature: As a user I should be able to work on vehicle contract

    Scenario Outline: User should be able to creat a vehicle contract

        Given User enters "<username>" and "<password>" and clicks on the login button
        And User clicks on the fleet module
        And  User clicks on the contract page
        And  User clicks on create vehicle contract page
        And  User enters info for contract and verifies
        And  User cancels the contract
        Then User logs out
     #   And   User checks if grid settings are functional
        Examples:
            | username      | password  |
            |storemanager79 |UserUser123|
            |storemanager80 |UserUser123|
            |salesmanager143|UserUser123|
            |salesmanager144|UserUser123|
            |salesmanager145|UserUser123|


