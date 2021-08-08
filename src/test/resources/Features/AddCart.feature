# @smoke
Feature: Adding products to cart


	Scenario Outline: Add to cart via login

		Given browser is open
		And navigate to hepsiburada

		When user logins to the hepsiburada
		And user is navigated to the home page
		And user searches for <prod>
		And pick one from the list
		And add to cart
		And close recommendation
		Then add from different store

		## koruma paketi sorusu da kapatilabilir ancak test 1. adimdan baslayacagi icin bu isleme gerek yok.

		Examples:
			| prod   |
			| iphone |
	# | maske  |

	@smoke
	Scenario: Add to cart without login
		Given browser ready
		And navigate user to hepsiburada

		When user selects category
		And selects subcategory
		And selects filter
		Then adds product to cart

