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

class CheckOutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckOutScreen()

        }

    }
}

@Preview(showBackground = true)
@Composable
fun CheckOutScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BarCheckOut()
        AddressSection()
        PaymentSection()
        DeliverySection()
        TotalSection()
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                val intent = Intent(context, CongratsActivity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .height(60.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "SUBMIT ORDER",
                fontFamily = NunitoSans,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
            )
        }
    }
}


@Composable
fun BarCheckOut() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
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
            "Check out",
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
fun AddressSection(
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Shipping Address",
                fontSize = 18.sp,
                fontWeight = FontWeight.W600,
                fontFamily = NunitoSans,
                color = Color(0xFF909090)
            )
            Image(
                painter = painterResource(id = R.drawable.img_edit),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { }
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    clip = false
                )
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Bruno Fernandes",
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 15.dp),
                fontFamily = NunitoSans,
                fontWeight = FontWeight.W700,
                fontSize = 18.sp
            )
            DividerItem()
            Text(
                text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 15.dp),
                fontFamily = NunitoSans,
                fontSize = 14.sp,
                lineHeight = 25.sp,
                color = Color(0xFF808080)
            )
        }
    }
}

@Composable
fun PaymentSection(
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Payment",
                fontSize = 18.sp,
                fontFamily = NunitoSans,
                fontWeight = FontWeight.W600,
                color = Color(0xFF909090)
            )
            Image(
                painter = painterResource(id = R.drawable.img_edit),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { }
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    clip = false
                )
                .background(color = Color.White, shape = RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.padding(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_payment),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 15.dp)
                        .width(32.dp)
                        .height(25.dp)
                )
            }
            Text(
                text = "**** **** **** 3947",
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 15.dp),
                fontFamily = NunitoSans,
                fontSize = 14.sp,
                lineHeight = 25.sp,
                fontWeight = FontWeight.W600,
                color = Color(0xFF242424)
            )
        }
    }
}

@Composable
fun DeliverySection(
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Delivery method",
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
                fontFamily = NunitoSans,
                color = Color(0xFF909090)
            )
            Image(
                painter = painterResource(id = R.drawable.img_edit),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { }
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    clip = false
                )
                .background(color = Color.White, shape = RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.padding(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_delivery),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 15.dp)
                        .width(89.dp)
                        .height(25.dp)
                )
            }
            Text(
                text = "Fast (2-3days)",
                modifier = Modifier
                    .padding(vertical = 12.dp, ),
                fontFamily = NunitoSans,
                fontSize = 14.sp,
                lineHeight = 25.sp,
                fontWeight = FontWeight.W700,
                color = Color(0xFF242424)
            )
        }
    }
}

@Composable
fun TotalSection() {
    Box(
        modifier = Modifier
            .padding(top = 30.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false
            )
            .background(color = Color.White, shape = RoundedCornerShape(8.dp)),
    ) {
        Column {
            Row (
                modifier = Modifier
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Order: ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = NunitoSans,
                    color = Color(0xFF808080)
               )
                Text(
                    text = "$ 95.00",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = NunitoSans,
                    color = Color(0xFF242424)
                    )
            }
            Row (
                modifier = Modifier
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Delivery: ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = NunitoSans,
                    color = Color(0xFF808080)
                )
                Text(
                    text = "$ 5.00",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = NunitoSans,
                    color = Color(0xFF242424)
                )
            }
            Row (
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Total: ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = NunitoSans,
                    color = Color(0xFF808080)
                )
                Text(
                    text = "$ 100.00",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = NunitoSans,
                    color = Color(0xFF242424)
                )
            }
        }
    }
}


