package com.example.asg


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asg.DataSource.stockdisplay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun orderAddScreen(
    checkoutbutton:()-> Unit={},
                   modifier:Modifier){

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    //val selectedProducts by cartViewModel.selectedProducts.observeAsState(emptyList())
    var valid by remember { mutableStateOf(false) }




    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "AddOrder") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        BadgedBox(
                            badge = {
                                Badge(Modifier.size(10.dp))
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Cart View"
                            )
                        }
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding).padding(8.dp)
        ) {
            items(DataSource.stockdisplay.size){
            }


            item{
                Button(
                    onClick = checkoutbutton,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                        .padding(16.dp)

                ) {
                    Text(text = "CheckOut")
                }

                }

            }

        }


    }





@Composable
fun CartView(
    productName: String,
    productPrice: Double,
    productImageId: Int
) {
    val counter = remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = productImageId),
            contentDescription = productName,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = productName,
                fontSize = 20.sp
            )

            Text(
                text = "$productPrice",
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        ValueDecreaseAndIncrease(
            value = counter.value,
            onIncrement = { counter.value++ },
            onDecrement = { if (counter.value > 0) counter.value-- },
            icon = Icons.Default.Add,
            iconContentDescription = "Increase",
            iconModifier = Modifier.size(20.dp)
        )
    }
}



@Composable
fun ValueDecreaseAndIncrease(
    value: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    icon: ImageVector,
    iconContentDescription: String,
    iconModifier: Modifier
) {
    Card(
        modifier = Modifier.clickable { onDecrement() },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.minus_512),
            contentDescription = "Decrease",
            modifier = iconModifier
        )
    }

    Spacer(modifier = Modifier.width(4.dp))

    Text(
        text = "$value",
        fontSize = 20.sp
    )

    Spacer(modifier = Modifier.width(4.dp))

    Card(
        modifier = Modifier.clickable { onIncrement() },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            imageVector = icon,
            contentDescription = iconContentDescription,
            modifier = iconModifier
        )
    }
}

//@Composable
//fun showCheckOutScreen(selectedProducts:List<Product>){
//var checknull by remember{mutableStateOf(true)}

//    if(checknull){
//        CheckoutScreen(selectedProducts=selectedProducts){
//            checknull=false
//        }
//    }
//
//
//
//}




@Preview(showBackground=true)
@Composable
fun OrderAddScreenPreview(){


}