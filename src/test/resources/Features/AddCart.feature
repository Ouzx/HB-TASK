Feature: Adding products to cart

	@smoke
	Scenario Outline: Add to cart via login

		Given browser is open
		And navigate to hepsiburada
		When user logins to the hepsiburada
		And user is navigated to the home page
		And user searches for <prod>
		And pick one from the list
		And add to cart
		And close recommendation
		And add from different store
		Then user have products from different stores
		## koruma paketi sorusu da kapatilabilir ancak test 1. adimdan baslayacagi icin bu isleme gerek yok.

		Examples:
			| prod   |
			| iphone |
# | maske  |
