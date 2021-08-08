@smoke
Feature: Adding products to cart without login

    Scenario: Add to cart without login
        Given browser ready
        And navigate user to hepsiburada

        When user selects category
        And selects subcategory
        And selects filter
        Then adds product to cart

