@file:OptIn(ExperimentalMaterial3Api::class)

package com.phwnam.furnitureshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.icon1), // Replace with your logo
            contentDescription = "App Logo",
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Hello!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "WELCOME BACK",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        UnderlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        UnderlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { /* handle show/hide password */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon1), // Replace with your eye icon
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { /* handle forgot password */ }) {
            Text("Forgot Password")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* handle login */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Log in")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { /* handle sign up */ }) {
            Text("SIGN UP")
        }
    }
}
@Composable
fun UnderlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = label,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            trailingIcon = trailingIcon,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Gray,
                focusedIndicatorColor = Color.Black,
                containerColor = Color.Transparent,
                cursorColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black
            )

        )
    }
}
//@Composable
//fun LoginScreen(){
//    val context = LocalContext.current
//    var userName by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    Column (
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight(),
//        horizontalAlignment = Alignment.CenterHorizontally
//
//    ){
//        Image(
//            painter = painterResource(id = R.drawable.icon1),
//            contentDescription = "Logo",
//            modifier = Modifier.size(60.dp)
//        )
//        Text(text = "Hello!")
//        Text(text = "WELCOME BACK")
//
//        OutlinedTextField(
//            value = userName,
//            onValueChange = {userName = it},
//            label = {Text(text ="Username")}
//        )
//    }
//
//}