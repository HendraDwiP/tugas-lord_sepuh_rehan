package com.example.tugas_lord_sepuh_rehan

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugas_lord_sepuh_rehan.component.IndomieItem
import com.example.tugas_lord_sepuh_rehan.data.MieData
import com.example.tugas_lord_sepuh_rehan.model.Indomie
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tugas_lord_sepuh_rehan.model.Masakan
import com.example.tugas_lord_sepuh_rehan.navigation.NavigationItem

@Composable
fun Detail(
    modifier: Modifier = Modifier,
    navController: NavController,
    masakanId: Int?
) {
    val newList = MieData.masakanMie.filter { masakan ->
        masakan.id == masakanId
    }
    Column(
        modifier = modifier
    ) {
        DetailContent(newList = newList)
    }
}

@Composable
private fun DetailContent(
    newList: List<Masakan>,
    //Masakan: Masakan,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = newList[0].photo),
            contentDescription = newList[0].name,
            //modifier = Modifier.fillMaxWidth()
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 360.dp, height = 300.dp)
        )
//        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = newList[0].name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tingkat kesulitan : "+ newList[0].tingkat,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = newList[0].deskripsi,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailMentorContentPreview() {
    DetailContent(newList = MieData.masakanMie )
}