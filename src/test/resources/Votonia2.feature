Feature: Работа с корзиной
  Background:
    Given Get Votonia
    And Scroll to top of page


    Scenario:
      When Click to Cart
      And Clean Cart
      And Click to  Clothes
      And Choose good
      And Remember good's name
      And Add good to Cart
      And Click to Cart
      Then Check good in Cart




