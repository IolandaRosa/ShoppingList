package com.example.shoppinglistapp.model

data class Product(
    var name: String,
    var brand: String="",
    var quantity: Int = 0,
    var myList: Boolean = false
)
