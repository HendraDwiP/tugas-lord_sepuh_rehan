package com.example.tugas_lord_sepuh_rehan.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas_lord_sepuh_rehan.R
import com.example.tugas_lord_sepuh_rehan.model.Masakan

@Composable
fun MasakanItem(
    Masakan: Masakan,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .clickable{
                onItemClicked(Masakan.id)
            }
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = Masakan.photo),
            contentDescription = Masakan.name,
            //modifier = Modifier.fillMaxWidth()
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 150.dp, height = 100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(start = 10.dp)
    ) {
        Text(
            text = Masakan.name,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = Masakan.tingkat,
            textAlign = TextAlign.Start,
            color = when (Masakan.tingkat) {
                "Eazy" -> Color.Green
                "Try Hard" -> Color(0xFFFC6A03)
                "Chef Kampus" -> Color.Red
                else -> Color.Black
            }
        )
    }
    }
}

@Preview
@Composable
private fun CourseItemPreview() {
        MasakanItem(
            Masakan = Masakan(
                1,
                "Jetpack Composes Introduction",
                "Chef Kampus",
                R.drawable.rendang,
                deskripsi = ""
            ),
            onItemClicked = { masakanId ->
                println("Mentor Id : $masakanId")
            }
        )
}