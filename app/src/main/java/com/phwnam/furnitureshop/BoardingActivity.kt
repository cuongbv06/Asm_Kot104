package com.phwnam.furnitureshop

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.phwnam.furnitureshop.ui.theme.Gelasio_Family
import com.phwnam.furnitureshop.ui.theme.NunitoSans

class BoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
        }

    }
}
@Preview(showBackground = true)
@Composable
fun previewBoarding(){
    val navController = rememberNavController() // Tạo một NavController giả
    BoardingScreen(navController = navController)
}
@Composable
fun BoardingScreen(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        Image(
            painter = painterResource(id = R.drawable.boarding),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop

        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(0.dp, top = 80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
            ) {
                Text(
                    text = "MAKE YOUR",
                    fontFamily = Gelasio_Family,
                    fontSize = 30.sp,
                    color = Color(0xFF606060),
                    modifier = Modifier
                        .padding(bottom = 0.dp)
                )
                Text(
                    text = "HOME BEAUTIFUL",
                    fontFamily = Gelasio_Family,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF303030)
                )
            }
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                color = Color(0xFF808080),
                fontFamily = NunitoSans,
                fontSize = 19.sp,
                modifier = Modifier
                    .padding(start = 60.dp, top = 30.dp, end = 30.dp),
                lineHeight = 40.sp
            )
            Spacer(modifier = Modifier.height(180.dp))
            Button(
                onClick = {
                          navController.navigate("login")
                          },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF242424)
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = " Get Started", fontFamily = Gelasio_Family, fontSize = 16.sp, modifier = Modifier.padding(5.dp))
            }


        }
    }

}