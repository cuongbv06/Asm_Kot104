package com.phwnam.furnitureshop.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phwnam.furnitureshop.R
import com.phwnam.furnitureshop.ui.theme.Gelasio_Family
import com.phwnam.furnitureshop.ui.theme.NunitoSans

data class Item(val image: Int, val text: String)


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(10.dp))
        CategorySection()
        ProductSection()

    }
}

@Composable
fun SearchBar() {
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
            Text("Make home ", fontFamily = Gelasio_Family, color = Color(0xFF909090), fontSize = 18.sp)

            Text("BEAUTIFUL", fontFamily = Gelasio_Family, fontWeight = FontWeight.W700, fontSize = 20.sp)
        }

        IconButton(onClick = { /* Handle cart click */ }) {
            Icon(painterResource(id = R.drawable.ic_cart), modifier = Modifier.size(24.dp), contentDescription = "Cart")
        }
    }
}

@Composable
fun CategorySection() {
    val items = listOf(
        Item(R.drawable.ic_popular, "Popular"),
        Item(R.drawable.ic_chair, "Chair"),
        Item(R.drawable.ic_table, "Table"),
        Item(R.drawable.ic_armchair, "Armchair"),
        Item(R.drawable.ic_bed, "Bed"),
        Item(R.drawable.ic_popular, "Lamp")
    )

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(items = items) { item ->
            ItemRow(item = item)
        }
    }
}
data class Product(val name: String, val price: String, val image: Int)

@Composable
fun ProductSection(){
    val products = listOf(
        Product("Black Simple Lamp", "12.00", R.drawable.lamp),
        Product("Minimal Stand", "25.00", R.drawable.stand),
        Product("Coffee Chair", "20.00", R.drawable.chair),
        Product("Simple Desk", "50.00", R.drawable.desk),
        Product("Black Simple Lamp", "12.00", R.drawable.lamp),
        Product("Minimal Stand", "25.00", R.drawable.stand),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(items = products){product ->
            ProductRow(item = product) {
//                val intent = Intent(context)
            }
        }
    }
}

@Composable
fun ItemRow(item: Item) {
    Box(
        modifier = Modifier.width(80.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
                    .background(color = Color(0xFFf5f5f5), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Text(text = item.text,
                fontSize = 14.sp,
                fontFamily = NunitoSans,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ProductRow(item: Product, onItemClick: () -> Unit){
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = onItemClick)
    ){
        Column (
            modifier = Modifier.padding(8.dp)
        ){
            Image(
                modifier = Modifier
                    .height(225.dp)
                    .width(177.dp)
                    .clip(RoundedCornerShape(20.dp)),
                painter = painterResource(id = item.image),
                contentDescription = null,

                )
            Spacer(modifier = Modifier.height(5.dp))

                Text(text = item.name, color = Color(0xFF606060), fontSize = 14.sp, fontFamily = NunitoSans)
                Text(text = "$ " + item.price, color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Bold, fontFamily = NunitoSans)

        }
    }
}

