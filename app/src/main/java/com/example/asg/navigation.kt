package com.example.asg

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Order(){
    add,
    checkout

}

@Composable
fun navigation(
    navController: NavController =rememberNavController()

){
    NavHost(
        navController=navController as NavHostController,
        startDestination=Order.add.name,
        modifier= Modifier
    ){
        composable(route=Order.add.name){
            orderAddScreen(
                modifier=Modifier.fillMaxSize()
                    .wrapContentSize(),
                checkoutbutton = {navController.navigate(Order.checkout.name)}
            )
        }

        composable(route=Order.checkout.name){
            CheckoutScreen(
                modifier=Modifier.fillMaxSize()
                    .wrapContentSize(),
                checkoutbutton = {}
            )
        }
    }
}