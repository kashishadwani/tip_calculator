package com.example.tip_calculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            frontscreen()
        }
    }
}
//@Preview
//@Composable
//fun frontscreen() {
//    val context = LocalContext.current
//    var inputText by remember { mutableStateOf("") } // Store input as string
//    var displaytip by remember { mutableStateOf(0.0) }
//    var selectedOption by remember { mutableStateOf("option2") }
//    var checked by remember { mutableStateOf(true) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxHeight()
//            .fillMaxWidth()
//            .background(Color(0xFFC5B9F0))
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start
//        // ... rest of your Column layout
//    ) {
//        // ... other elements
//        TextField(value = inputText, onValueChange = {inputText=it}, modifier = Modifier.padding(16.dp),
//            placeholder = { Text(text = "Cost of service")}, keyboardOptions = KeyboardOptions(
//                capitalization = KeyboardCapitalization.None,
//                keyboardType = KeyboardType.Decimal
//            )
//        )
//        var input =inputText
//        Text(text = "How was the service ?", modifier = Modifier
//            .padding(16.dp, 10.dp),
//            fontSize = 20.sp
//        )
//        val selectedoption = remember {
//            mutableStateOf("option2")
//        }
//        Column {
//            Row {
//                RadioButton(selected = selectedoption.value=="option1", onClick = { selectedoption.value="option1" }
//                )
//                Text(text = "Amazing (20%) ", fontSize = 18.sp, modifier = Modifier.padding(0.dp,10.dp))
//            }
//            Row {
//                RadioButton(selected = selectedoption.value=="option2", onClick = { selectedoption.value="option2" }
//                )
//                Text(text = "Good (18%) ", fontSize = 18.sp, modifier = Modifier.padding(0.dp,10.dp))
//            }
//            Row {
//                RadioButton(selected = selectedoption.value=="option3", onClick = { selectedoption.value="option3" }
//                )
//                Text(text = "Okay (15%) ", fontSize = 18.sp, modifier = Modifier.padding(0.dp,10.dp))
//            }
//        }
//        Row(modifier = Modifier.padding(16.dp)) {
//            Text(text = "Round Up Tip ? ", modifier = Modifier.padding(0.dp,10.dp,140.dp,0.dp), fontSize = 22.sp)
//            Switch(checked = checked, onCheckedChange = {checked=it})
//        }
//        Button(
//            onClick = { recalculateTip() }, // Trigger calculation on button click
//            // ... button modifiers
//            modifier = Modifier
//           .padding(12.dp)
//            .fillMaxWidth()
//            .wrapContentHeight(),
//            border = BorderStroke(1.dp, color = Color.White),
//            shape = MaterialTheme.shapes.medium
//        ) {
//            Text(text = "Calculate", fontSize = 30.sp)
//        }
//
//        Text(text = "Tip amount = $displaytip", modifier = Modifier.padding(16.dp), fontSize = 22.sp)
//    }
//
//    fun recalculateTip() {
//        val input = inputText.toDoubleOrNull() ?: 0.0 // Handle potential non-numeric input
//        val tipPercentage = when (selectedOption) {
//            "option1" -> 20.0
//            "option2" -> 18.0
//            "option3" -> 15.0
//            else -> 0.0
//        }
//        displaytip = if (checked) {
//            kotlin.math.ceil(input * tipPercentage / 100) // Round up if checked
//        } else {
//            input * tipPercentage / 100
//        }
//    }
//}


@Preview
@Composable
fun frontscreen(){
    val context = LocalContext.current
    //var inputvalue = remember { mutableStateOf(TextFieldValue()) }
    var inputvalue by remember { mutableStateOf("0") }
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color(0xFFC5B9F0))
        .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        TextField(value = inputvalue, onValueChange = {inputvalue=it}, modifier = Modifier.padding(16.dp),
            placeholder = { Text(text = "Cost of service")}, keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Number
            )
        )
        var input =inputvalue
        Text(text = "How was the service ?", modifier = Modifier
            .padding(16.dp, 10.dp),
            fontSize = 20.sp
        )
        val selectedoption = remember {
            mutableStateOf("option2")
        }
        Column {
            Row {
                RadioButton(selected = selectedoption.value=="option1", onClick = { selectedoption.value="option1" }
                )
                Text(text = "Amazing (20%) ", fontSize = 18.sp, modifier = Modifier.padding(0.dp,10.dp))
            }
            Row {
                RadioButton(selected = selectedoption.value=="option2", onClick = { selectedoption.value="option2" }
                )
                Text(text = "Good (18%) ", fontSize = 18.sp, modifier = Modifier.padding(0.dp,10.dp))
            }
            Row {
                RadioButton(selected = selectedoption.value=="option3", onClick = { selectedoption.value="option3" }
                )
                Text(text = "Okay (15%) ", fontSize = 18.sp, modifier = Modifier.padding(0.dp,10.dp))
            }
        }
        var tip_percentage = 0
        if (selectedoption.value=="option1"){ tip_percentage =20}
        else if (selectedoption.value=="option2"){ tip_percentage =18}
        else {tip_percentage =15}
       // var tip:Double = (input.toDouble() * tip_percentage)/100
        var checked = remember {
            mutableStateOf(true)
        }
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Round Up Tip ? ", modifier = Modifier.padding(0.dp,10.dp,140.dp,0.dp), fontSize = 22.sp)
            Switch(checked = checked.value, onCheckedChange = {checked.value=it})
        }
        var displaytip= (input.toInt()*tip_percentage)/100
        Button(onClick = { Toast.makeText(context, "Here's your tip $displaytip!", Toast.LENGTH_LONG).show() }, modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
            border = BorderStroke(1.dp, color = Color.White),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Calculate", fontSize = 30.sp)
        }
        //Text(text = "Tip amount = $displaytip", modifier = Modifier.padding(16.dp), fontSize = 22.sp)
    }
}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//
//}
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            frontscreen()
//        }
//    }
//}
//
//@Preview
//@Composable
//fun frontscreen() {
//    val context = LocalContext.current
//    var inputvalue = remember { mutableStateOf(TextFieldValue()) }
//    var displaytip by remember { mutableStateOf(0.0) } // Use MutableState for displaytip
//
//    Column(
//        modifier = Modifier
//            .fillMaxHeight()
//            .fillMaxWidth()
//            .background(Color(0xFFC5B9F0))
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start
//    ) {
//        TextField(
//            value = inputvalue.value,
//            onValueChange = { inputvalue.value = it },
//            modifier = Modifier.padding(16.dp),
//            placeholder = { Text(text = "Cost of service") },
//            keyboardOptions = KeyboardOptions(
//                capitalization = KeyboardCapitalization.None,
//                keyboardType = KeyboardType.Decimal
//            )
//        )
//        var input = inputvalue.value.hashCode()
//        Text(
//            text = "How was the service ?",
//            modifier = Modifier.padding(16.dp, 10.dp),
//            fontSize = 20.sp
//        )
//        val selectedoption = remember {
//            mutableStateOf("option2")
//        }
//        Column {
//            Row {
//                RadioButton(
//                    selected = selectedoption.value == "option1",
//                    onClick = { selectedoption.value = "option1" }
//                )
//                Text(
//                    text = "Amazing (20%) ",
//                    fontSize = 18.sp,
//                    modifier = Modifier.padding(0.dp, 10.dp)
//                )
//            }
//            Row {
//                RadioButton(
//                    selected = selectedoption.value == "option2",
//                    onClick = { selectedoption.value = "option2" }
//                )
//                Text(
//                    text = "Good (18%) ",
//                    fontSize = 18.sp,
//                    modifier = Modifier.padding(0.dp, 10.dp)
//                )
//            }
//            Row {
//                RadioButton(
//                    selected = selectedoption.value == "option3",
//                    onClick = { selectedoption.value = "option3" }
//                )
//                Text(
//                    text = "Okay (15%) ",
//                    fontSize = 18.sp,
//                    modifier = Modifier.padding(0.dp, 10.dp)
//                )
//            }
//        }
//        var tip_percentage: Double = 0.0
//        if (selectedoption.value == "option1") {
//            tip_percentage = 20.0
//        } else if (selectedoption.value == "option2") {
//            tip_percentage = 18.0
//        } else if (selectedoption.value == "option3") {
//            tip_percentage = 15.0
//        }
//        var checked = remember {
//            mutableStateOf(true)
//        }
//        Row(modifier = Modifier.padding(16.dp)) {
//            Text(
//                text = "Round Up Tip ? ",
//                modifier = Modifier.padding(0.dp, 10.dp, 140.dp, 0.dp),
//                fontSize = 22.sp
//            )
//            Switch(checked = checked.value, onCheckedChange = { checked.value = it })
//        }
//        var clicked: Boolean by remember { mutableStateOf(false) }
//
//        // Observe changes to input, tip_percentage, and checked values
//
//        Button(
//            onClick = { clicked = true },
//            modifier = Modifier
//                .padding(12.dp)
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            border = BorderStroke(1.dp, color = Color.White),
//            shape = MaterialTheme.shapes.medium
//        ) {
//            Text(text = "Calculate", fontSize = 30.sp)
//        }
//        Text(text = "Tip amount = $displaytip", modifier = Modifier.padding(16.dp), fontSize = 22.sp)
//    }
//}
//@Composable
//fun Appname(name: String,Size:Int){
//    Text (text = "welcome to $name",
//    fontSize = Size.sp
//    )
//}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Tip_calculatorTheme {
//        Greeting("user")
//    }
//}
