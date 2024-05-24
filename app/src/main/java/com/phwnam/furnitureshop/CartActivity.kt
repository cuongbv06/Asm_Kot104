package com.phwnam.furnitureshop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phwnam.furnitureshop.ui.theme.Merriweather
import com.phwnam.furnitureshop.ui.theme.NunitoSans

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BarCart()
        CartSection()

    }
}

data class Product(val name: String, val price: String, val image: Int)

@Composable
fun BarCart() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp,),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {
            val activity = context as? Activity
            activity?.finish()
        }) {
            Icon(
                painterResource(id = R.drawable.ic_back),
                modifier = Modifier.size(24.dp),
                contentDescription = "Back"
            )
        }
        Text(
            "My cart",
            fontWeight = FontWeight.W700,
            fontFamily = Merriweather,
            color = Color(0xFF303030),
            fontSize = 18.sp
        )

        IconButton(onClick = { /* Handle cart click */ }) {
            Icon(
                painterResource(id = R.drawable.ic_cart),
                modifier = Modifier.size(24.dp),
                contentDescription = "Cart",
                tint = Color.White
            )
        }
    }
}


@Composable
fun CartSection() {
    var code by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    val products = listOf(
        Product("Black Simple Lamp", "12.00", R.drawable.lamp),
        Product("Minimal Stand", "25.00", R.drawable.stand),
        Product("Coffee Chair", "20.00", R.drawable.chair),
        Product("Simple Desk", "50.00", R.drawable.desk),
        Product("Black Simple Lamp", "12.00", R.drawable.lamp),
        Product("Minimal Stand", "25.00", R.drawable.stand),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(580.dp)
    ) {
        items(items = products) { item ->
            CartItem(item = item)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxHeight(),
    ){
        Column (
            modifier = Modifier.fillMaxHeight()
        ){
            Spacer(modifier = Modifier.weight(1f))
            PromoCodeInput()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Total: ",
                    fontSize = 20.sp,
                    fontFamily = NunitoSans,
                    fontWeight = FontWeight.W600,
                    lineHeight = 31.sp,
                    color = Color(0xFF808080)
                )
                Text(
                    text = "$ 95.00",
                    fontSize = 22.sp,
                    lineHeight = 31.sp,
                    fontFamily = NunitoSans,
                    fontWeight = FontWeight.W700,
                    color = Color.Black
                )
            }
            Button(
                onClick = {
                        val intent = Intent(context, CheckOutActivity::class.java)
                        context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(10.dp)
                    .height(60.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Check out",
                    fontFamily = NunitoSans,
                    fontWeight = FontWeight.W400,
                    fontSize = 20.sp,
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoCodeInput() {
    val promoCode = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false
            )
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = promoCode.value,
                onValueChange = { promoCode.value = it },
                placeholder = {
                    Text(
                        text = "Enter your promo code",
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(14.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                textStyle = TextStyle(color = Color.Black)
            )
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Black, shape = RoundedCornerShape(12.dp))
                    .clickable { /* Handle promo code submission */ },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_next),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun CartItem(item: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))

        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .height(100.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.name,
                fontSize = 14.sp,
                color = Color(0xFF999999),
                fontFamily = NunitoSans
            )
            Text(
                text = "$ " + item.price ,
                fontSize = 16.sp,
                color = Color(0xFF242424),
                fontFamily = NunitoSans,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_plus),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { }
                )
                androidx.compose.material.Text(
                    text = "01",
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp),
                    fontSize = 18.sp,
                    fontFamily = NunitoSans

                )
                Image(
                    painter = painterResource(id = R.drawable.img_minus),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { }
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.img_delete),
            modifier = Modifier.size(25.dp),
            contentDescription = null
        )
    }
    DividerItem()
}

@Composable
fun DividerItem() {
    Divider(
        color = Color(0xFFF0F0F0),
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth()
    )
}