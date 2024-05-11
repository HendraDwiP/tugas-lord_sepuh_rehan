package com.example.tugas_lord_sepuh_rehan.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.tugas_lord_sepuh_rehan.model.Indomie
import com.example.tugas_lord_sepuh_rehan.data.MieData

@Composable
fun IndomieItem(
    indomie: Indomie,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp)
            .size(width = 170.dp, height = 210.dp)

    ) {
        Image(
            painter = painterResource(id = indomie.photo),
            contentDescription = indomie.name,
            //modifier = Modifier.fillMaxWidth()
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 150.dp, height = 100.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = indomie.name,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = indomie.jenis,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

//@Preview
//@Composable
//private fun CourseItemPreview() {
//    InfiniteAppTheme {
//        CourseItem(
//            course = Course(
//                1,
//                "Jetpack Compose Introduction",
//                "Beginner",
//                R.drawable.compose_introduction
//            )
//        )
//    }
//}