package com.example.calenderapplication

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calenderapplication.ui.theme.CalenderApplicationTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalenderApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                    Calender1(this)
                }
            }
        }
    }
}


@Composable
fun Calender1(context : Context) {

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    //initialize a calender
    val calendar = Calendar.getInstance()

    //fetch data of current data, month and year
    mYear = calendar.get(Calendar.YEAR)
    mMonth = calendar.get(Calendar.MONTH)
    mDay = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.time = Date()

    val mDate = remember { mutableStateOf("") }

    val datePickerDialog =
        DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                mDate.value = "$day/$month/$year"
            }, mYear, mMonth, mDay
        )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

                Text(
                    text = "$mDate",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 22.sp,

                    )
                OutlinedButton(onClick = { datePickerDialog.show() }) {
                    Text(text = "Open Calendar")
                }
    }

}
