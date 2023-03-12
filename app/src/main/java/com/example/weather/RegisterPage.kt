package com.example.weather

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weather.ui.theme.whiteBackground


@Composable
fun RegisterPage() {
    val image = 

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ){
            Image(image)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.70f)
                .clip(RoundedCornerShape(topLeft = 30.dp, topRight = 30.dp))
                .background(whiteBackground)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            ScrollableColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangment = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {
                Text(
                    text = "Sign Up",
                    fontSize = TextUnit.Sp(30),
                    style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = TextUnit.Companion.Sp(2)
                    )
                    )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally)
                {
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = { nameValue.value = it},
                        label = {Text(text = "Name")},
                        placeholder = { Text(text = "Name")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it},
                        label = {Text(text = "Email Address")},
                        placeholder = { Text(text = "Email Address")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(
                        value = phoneValue.value,
                        onValueChange = { phoneValue.value = it},
                        label = {Text(text = "Phone Number")},
                        placeholder = { Text(text = "Phone Number")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardOptions = keyboardOptions(keyboardType = KeyboardType.Number)

                    )
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it},
                        label = {Text(text = "Password")},
                        placeholder = { Text(text = "Password")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                PasswordVisibility.value= !passwordVisibilty.value
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Password,
                                    tint = if (passwordVisibility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    OutlinedTextField(
                        value = confirmPasswordValue.value,
                        onValueChange = { confirmPasswordValue.value = it},
                        label = {Text(text = "Confirm Password")},
                        placeholder = { Text(text = "Confirm Password")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                PasswordVisibility.value= !passwordVisibilty.value
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Password,
                                    tint = if (passwordVisibility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Button(onClick = {  },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ){
                        Text(text = "Sign Up", fontSize = TextUnit.Companion.Sp(20))
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(text = "Login Instead",
                    modifier = Modifier.clickable(OnClick ={
                        navController.navigate("login_page"){
                            popUpTo = navController.graph.startDestination
                            launchSingleTop = true
                        }
                    })
                        )
                    Spacer(modifier = Modifier.padding(20.dp))
                }
            }

        }
    }
}

