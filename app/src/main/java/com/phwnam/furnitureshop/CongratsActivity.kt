package com.phwnam.furnitureshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.phwnam.furnitureshop.bottomNav.BottomMainScreen
import com.phwnam.furnitureshop.screens.HomeScreen
import com.phwnam.furnitureshop.ui.theme.Merriweather
import com.phwnam.furnitureshop.ui.theme.NunitoSans

class CongratsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            CongratsScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CongratsScreen(){
    val context = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "SUCCESS!",
            fontSize = 36.sp,
            fontWeight = FontWeight.W700,
            fontFamily = Merriweather,
            color = Color(0xFF303030)
        )
        Image(
            painter = painterResource(id = R.drawable.img_success),
            contentDescription = null,
            modifier = Modifier
                .width(220.dp)
                .height(200.dp)
                .padding(top = 40.dp),
        )
        Image(
            painter = painterResource(id = R.drawable.img_greentick),
            contentDescription = null,
            modifier = Modifier

        )
        Text(
            text = "Your order will be delivered soon.\n" +
                    "Thank you for choosing our app!",
            fontSize = 18.sp,
            fontWeight = FontWeight.W400,
            fontFamily = NunitoSans,
            color = Color(0xFF606060),
            lineHeight = 27.sp,
            modifier = Modifier.
            padding(25.dp)
        )
        Button(
            onClick = {
//                val intent = Intent(context, CheckOutActivity::class.java)
//                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(10.dp)
                .height(60.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Track your orders",
                fontFamily = NunitoSans,
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
            )
        }
        Button(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(10.dp)
                .height(60.dp)
                .fillMaxWidth()
                .border(
                    width = 1.dp, // Độ dày của viền
                    color = Color(0xFF303030), // Màu của viền
                    shape = RoundedCornerShape(8.dp) // Hình dạng của viền (cùng hình dạng với button)
                )
        ) {
            Text(
                text = "BACK TO HOME",
                fontFamily = NunitoSans,
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
                color = Color(0xFF303030)
            )
        }
    }
}