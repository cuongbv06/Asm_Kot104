package com.phwnam.furnitureshop

import android.app.Activity
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phwnam.furnitureshop.ui.theme.Gelasio_Family
import com.phwnam.furnitureshop.ui.theme.NunitoSans

class ProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ProductScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreen(){
    val context = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = R.drawable.stand),
                contentDescription = null,
                modifier = Modifier
                    .height(500.dp)
                    .width(360.dp)
                    .align(Alignment.TopEnd)
//                    .aspectRatio(350f / 450f)
                    .clip(RoundedCornerShape(bottomStart = 60.dp)),

                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .padding(25.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(5.dp),
                        clip = true
                    )
                    .clickable {
                        (context as? Activity)?.finish()
                    }

            ) {
                // Hộp chứa hình dạng của box
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(5.dp))
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center),
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.color),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
                    .padding(top = 150.dp)
                    .padding(start = 0.dp),
                alignment = Alignment.TopStart
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.White),
            ) {
                Text(
                    text = "Minimal Stand",
                    fontSize = 30.sp,
                    fontFamily = Gelasio_Family,
                    lineHeight = 31.sp,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$ 50",
                        fontSize = 35.sp,
                        fontFamily = NunitoSans,
                        lineHeight = 31.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.img_plus),
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                                .clickable {  }
                        )
                        Text(
                            text = "01",
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp),
                            fontSize = 24.sp,
                            fontFamily = NunitoSans

                        )
                        Image(
                            painter = painterResource(id = R.drawable.img_minus),
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                                .clickable {  }
                        )
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Text(
                        text = " 4.5    ",
                        fontSize = 20.sp,
                        fontFamily = NunitoSans,
                        lineHeight = 31.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "  (50 reviews)",
                        fontFamily = NunitoSans,
                        fontSize = 15.sp,
                        lineHeight = 31.sp,
                        color = Color.Gray
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
                    fontSize = 15.sp,
                    fontFamily = NunitoSans,
                    color = Color.Gray,
                    lineHeight = 20.sp,

                    )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.frame),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clickable {  }
                    )
                    Button(
                        onClick = {
//                            val intent = Intent(context, CartActivity::class.java)
//                            context.startActivity(intent)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF242424)
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .weight(1f)
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Add to cart",
                            fontSize = 20.sp,
                            fontFamily = NunitoSans,
                            lineHeight = 31.sp,
                            color = Color.White
                        )
                    }
                }

            }
        }
    }
}