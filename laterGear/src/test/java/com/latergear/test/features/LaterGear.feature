Feature: To verify if customer is able to checkout the selected item


  @testProducts
  Scenario Outline: Customer is able to navigate to shopify and checkout items

    Given Customer is on Later gear page
    When customer selects the "<Product>"
    And adds to cart
    And clicks on checkout
    Then customer should be on payments page
#    And the product summary should be displayed on the side of screen

    Examples:
    |Product                            |
    |Fifteen 52 Turbomac wheels         |
    |Ladies Black and Green wet suit   |
    | Fox Racing black Helmet           |
    | Once upon a time in Shaolin       |
    | VR One                            |
    | Matt Miller DC Signature Shoe     |
    | Burton board                      |