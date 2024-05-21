package com.phwnam.furnitureshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Preview(showBackground = true)

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        SearchBar()
        CategorySection()
        ProductGrid()
//        BottomNavigationBar()
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /* Handle search click */ }) {
            Icon(painterResource(id = R.drawable.ic_search), contentDescription = "Search")
        }
        Text("Make home BEAUTIFUL", fontWeight = FontWeight.Bold, fontSize = 24.sp)

        IconButton(onClick = { /* Handle cart click */ }) {
            Icon(painterResource(id = R.drawable.ic_cart), contentDescription = "Cart")
        }
    }
}

@Composable
fun CategorySection() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listOf("Popular", "Table", "Armchair", "Bed", "Lamp")) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: String) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_category),
                contentDescription = category,
                modifier = Modifier
                    .width(28.dp)
                    .height(28.dp)
            )
        }
        Text(category, fontSize = 12.sp)
    }
}
data class Product(val name: String, val price: String, val imageRes: Int)

@Composable
fun ProductGrid() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listOf(
            Product("Black Simple Lamp", "$12.00", R.drawable.lamp),
            Product("Minimal Stand", "$25.00", R.drawable.stand),
            Product("Coffee Chair", "$20.00", R.drawable.chair),
            Product("Simple Desk", "$50.00", R.drawable.desk)
        )) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(product.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(product.price, color = Color.Gray, fontSize = 14.sp)
        }
    }
}

//@Composable
//fun BottomNavigationBar() {
//    BottomNavigation(
//        backgroundColor = Color.White,
//        elevation = 8.dp
//    ) {
//        BottomNavigationItem(
//            icon = { Icon(painterResource(id = R.drawable.ic_home), contentDescription = "Home") },
//            selected = true,
//            onClick = { /* Handle home click */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(painterResource(id = R.drawable.ic_favorite), contentDescription = "Favorite") },
//            selected = false,
//            onClick = { /* Handle favorite click */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(painterResource(id = R.drawable.ic_notification), contentDescription = "Notification") },
//            selected = false,
//            onClick = { /* Handle notification click */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(painterResource(id = R.drawable.ic_profile), contentDescription = "Profile") },
//            selected = false,
//            onClick = { /* Handle profile click */ }
//        )
//    }
//
//}