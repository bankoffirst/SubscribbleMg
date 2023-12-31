package com.example.subscribble.activities


import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.IconButton
import androidx.compose.ui.draw.shadow
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.subscribble.database.CardList
import com.example.subscribble.database.module.SubscriptionViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPayment(navController: NavController,cardViewmodel:SubscriptionViewModel = hiltViewModel()) {

    val cards = cardViewmodel.cards.collectAsState(initial = emptyList())

    val name = remember {
        mutableStateOf("")
    }

    val detail = remember {
        mutableStateOf("")
    }

    val alert = remember {
        mutableStateOf("")
    }

    val total = 0f
    val formattedTotal = String.format("%.2f", total)
    val videoPrice = 0f
    val formattedvideoPrice = String.format("%.2f", videoPrice)
    val musicPrice = 0f
    val formattedmusicPrice = String.format("%.2f", musicPrice)
    var textName by remember { mutableStateOf("") }
    var textDetail by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 26.dp, top = 22.dp, bottom = 22.dp)
                    .clickable { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    modifier = Modifier.size(35.dp)
                )
                Spacer(modifier = Modifier.width(8.dp)) // Add some spacing between the icon and text

                Text(
                    text = "Add",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
            }
        }
    ) { contentPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column(modifier = Modifier.fillMaxHeight()) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(750.dp)
                        .padding(start = 20.dp, end = 20.dp, top = 0.dp)
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            //.padding(start = 20.dp, end = 20.dp)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(20.dp),
                                spotColor = Color.LightGray
                            )
                            .height(200.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Black)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 22.dp, start = 26.dp, end = 26.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = textName, //card name
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.White
                            )
                            Text(
                                text = "$formattedTotal THB",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color(0xFF0AA6EC),
                                textAlign = TextAlign.Right,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 22.dp, start = 26.dp, end = 26.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = textDetail, // credit card number
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 22.dp, start = 26.dp, end = 26.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "Video Streaming",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color(0xFF808080)
                            )
                            Text(
                                text = "$formattedvideoPrice THB",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color(0xFF808080),
                                textAlign = TextAlign.Right,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 26.dp, end = 26.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "Music Streaming",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color(0xFF808080)
                            )
                            Text(
                                text = "$formattedmusicPrice THB",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color(0xFF808080),
                                textAlign = TextAlign.Right,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                    }

                    Text(
                        text = "Credit or Debit Name",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 26.dp, top = 60.dp)
                    )

                    //textName

                    TextField(
                        value = textName,
                        onValueChange = { textName = it },
                        modifier = Modifier.padding(start = 26.dp, top = 10.dp),
                        placeholder = { Text(text = "Credit or Debit Name") },
                        shape = RectangleShape,
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                        maxLines = 1
                    )

                    Text(
                        text = "Details",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 26.dp, top = 50.dp)
                    )

                    //textDetail

                    TextField(
                        value = textDetail,
                        onValueChange = { textDetail = it },
                        modifier = Modifier.padding(start = 26.dp, top = 10.dp),
                        placeholder = { Text(text = "Details of Card") },
                        shape = RectangleShape,
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                        maxLines = 1,
                        singleLine = true
                    )

                    Column(modifier = Modifier.padding(start = 26.dp, top = 30.dp)) {
                        Text(
                            text = alert.value,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )

                        //Icon Add

                        IconButton(
                            onClick = {
                                if (textName != "") {
                                    cardViewmodel.insertCard(
                                        CardList(
                                            name = textName,
                                            detail = textDetail,
                                        )
                                    ); navController.popBackStack()
                                } else {
                                    alert.value = "Please Fill Card Name"
                                }
                                //println("Card Name : $textName. And Details : $textDetail")
                            },
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    tint = Color(0xFFD9D9D9),
                                    modifier = Modifier
                                        .size(50.dp)
                                        .background(color = Color.Black)
                                )
                            },
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 150.dp)
                                .clip(CircleShape)
                                .size(50.dp)
                        )

                    }

                }


            }
        }

    }
}

//test test

//@Preview(showBackground = true, device = "spec:width=1440px,height=3088px,dpi=441")
//@Composable
//fun NewPaymentPreview() {
//    AddPayment()
//}
