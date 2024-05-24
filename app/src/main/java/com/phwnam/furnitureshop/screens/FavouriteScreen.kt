package com.phwnam.furnitureshop.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phwnam.furnitureshop.CartActivity
import com.phwnam.furnitureshop.CheckOutActivity
import com.phwnam.furnitureshop.R
import com.phwnam.furnitureshop.ui.theme.Merriweather
import com.phwnam.furnitureshop.ui.theme.NunitoSans

@Preview(showBackground = true)
@Composable
fun FavouriteScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        SearchBarFavourite()
        Spacer(modifier = Modifier.height(10.dp))

        FavouriteSection()
    }
}

@Composable
fun SearchBarFavourite() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 12.dp, end = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /* Handle search click */ }) {
            Icon(painterResource(id = R.drawable.ic_search,), modifier = Modifier.size(24.dp), contentDescription = "Search")
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                "Favorites",
                fontWeight = FontWeight.W700,
                fontFamily = Merriweather,
                color = Color(0xFF303030),
                fontSize = 18.sp
            )
        }

        IconButton(onClick = {
            val intent = Intent(context, CartActivity::class.java)
            context.startActivity(intent)
        }) {
            Icon(painterResource(id = R.drawable.ic_cart), modifier = Modifier.size(24.dp), contentDescription = "Cart")
        }
    }
}

data class Favourite(val name: String, val price: String, val image: Int)


@Composable
fun FavouriteSection() {

    var code by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    val products = listOf(
        Favourite("Black Simple Lamp", "12.00", R.drawable.lamp),
        Favourite("Minimal Stand", "25.00", R.drawable.stand),
        Favourite("Coffee Chair", "20.00", R.drawable.chair),
        Favourite("Simple Desk", "50.00", R.drawable.desk),
        Favourite("Black Simple Lamp", "12.00", R.drawable.lamp),
        Favourite("Minimal Stand", "25.00", R.drawable.stand),
        Favourite("Coffee Chair", "20.00", R.drawable.chair),
        Favourite("Simple Desk", "50.00", R.drawable.desk),
    )

    Box (
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .height(600.dp)
        ) {
            items(items = products) { item ->
                FavoriteItem(item = item)
            }
        }
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(top = 700.dp, start = 15.dp, end = 15.dp)
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Add all to my cart",
                fontFamily = NunitoSans,
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
            )
        }
    }
}

@Composable
fun FavoriteItem(item: Favourite) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
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

        }
        Column (
            modifier = Modifier
                .height(100.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = painterResource(id = R.drawable.img_delete),
                modifier = Modifier
                    .size(25.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                contentDescription = null,

            )
            Box(
                modifier = Modifier
                    .width(34.dp)
                    .height(34.dp)
                    .background(color = Color(0xFFE0E0E0), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_category_black),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
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