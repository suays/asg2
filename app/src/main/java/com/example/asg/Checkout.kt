package com.example.asg


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckoutScreen(checkoutbutton:()-> Unit={},
                   modifier:Modifier){

    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(text="Checkout")
        }

        Spacer(modifier=Modifier.padding(16.dp))

        Button(onClick={}){
            Text("Confirm Order.Create it!")
        }
    }


