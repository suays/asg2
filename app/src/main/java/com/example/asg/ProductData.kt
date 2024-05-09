package com.example.asg

data class Product(
    val productname:String,
    val price:Double,
    val quantity:Int
)

object DataSource{
    val stockdisplay=mutableListOf(
        Pair("Bread1",12.99),
        Pair("Bread2",12.99),
        Pair("Bread3",12.99),
        Pair("Bread4",12.99),
        Pair("Bread5",12.99),
        Pair("Bread6",12.99),
        Pair("Bread7",12.99),
        Pair("Bread8",12.99)
    )


}
