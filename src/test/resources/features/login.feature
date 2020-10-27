@login
  Feature:User should be able to login with right credentials

    Background: User is on the login page
      Given User navigates to the login url

    Scenario Outline:
      Given User enter "<username>" and "<password>" and clicks on the login button
      Then User should logout
      Examples:
        | username      | password  |
        |storemanager79 |UserUser123|
        |storemanager80 |UserUser123|
        |salesmanager143|UserUser123|
        |salesmanager144|UserUser123|
        |salesmanager145|UserUser123|



