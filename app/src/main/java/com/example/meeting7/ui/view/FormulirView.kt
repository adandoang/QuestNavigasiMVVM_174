package com.example.meeting7.ui.view
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meeting7.model.DataJK

@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    pilihanJK: List<String>,
    onClickButton: (MutableList<String>) -> Unit
) {

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nohp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var jeniskelamin by remember { mutableStateOf("") }
    var listData : MutableList<String> = mutableListOf(nama, jeniskelamin, email, nohp, alamat, nim)

    Column (modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("BIO",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Name") },
            placeholder = {
                Text("Input Your Name!", color = Color.Gray)
            }
        )
        Row {
            pilihanJK.forEach{selectedJK ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = jeniskelamin == selectedJK,
                        onClick = {
                            jeniskelamin = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Email") },
            placeholder = {
                Text("Input Your Email!", color = Color.Gray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = nohp,
            onValueChange = {nohp = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("No Handphone") },
            placeholder = {
                Text("Input Your Number!", color = Color.Gray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Address") },
            placeholder = {
                Text("Input Your Address!", color = Color.Gray)
            }
        )

        TextField(
            value = nim,
            onValueChange = {nim = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("NIM") },
            placeholder = {
                Text("Input Your NIM!", color = Color.Gray)
            }
        )

        Button(onClick = {
            onClickButton(listData)
        }, modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Submit")
        }
    }
}