package com.example.tugas_lord_sepuh_rehan

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tugas_lord_sepuh_rehan.navigation.NavigationItem

@Composable
fun About(
    navController: NavController,
    modifier: Modifier = Modifier,

) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Row(
        ) {
            Image(
                painter = painterResource(id = R.drawable.profil),
                contentDescription = "orang_ganteng",
                //modifier = Modifier.fillMaxWidth()
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(width = 80.dp, height = 80.dp)
            )
//        Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = "Hendra Dwi Prastia",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Hendrapang888@gmail.com",
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.padding(4.dp)
        ) {
            Row(
            ) {
                Icon(imageVector = Icons.Default.LocationOn
                    , contentDescription = "Study")
                Text(
                    text = "Sekolah Tinggi Teknologi Indonesia",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            Row(
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Study")
                Text(
                    text = "Teknik Informatika",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp)
            .border(width = 2.dp, color = Color.Black) )
        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Saya Hendra Dwi Prastia atau biasa kerap di panggil Hendra merupakan mahasiswa aktif di sekolah tinggi teknologi indonesia. Saat ini saya sedang menjalani program MSIB Studi Independen Mobile Developer di Infinite Learning ",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//private fun DetailMentorContentPreview() {
//    About()
//}