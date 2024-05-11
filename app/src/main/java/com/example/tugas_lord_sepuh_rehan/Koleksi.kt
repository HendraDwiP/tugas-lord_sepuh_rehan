package com.example.tugas_lord_sepuh_rehan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugas_lord_sepuh_rehan.data.MieData
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.tugas_lord_sepuh_rehan.component.MasakanItem
import com.example.tugas_lord_sepuh_rehan.model.Masakan
import com.example.tugas_lord_sepuh_rehan.navigation.Screen

@Composable
fun Koleksi (
    navController: NavController,
    modifier: Modifier = Modifier,
    masakans: List<Masakan> = MieData.masakanMie ,
) {
    Surface(
        color = Color(0xF1F1F1F1),
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
        ) {
            item {
//            LazyRow(
//                contentPadding = PaddingValues(16.dp),
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                modifier = modifier
//            ) {
//                items(masakans, key = { it.id }) {
//                    MasakanItem(Masakan = it) { masakanId ->
//                        navController.navigate("${Screen.Detail.route}/$masakanId")
//                    }
//                }
//            }
            }
            items(masakans, key = { it.id }) {
                MasakanItem(Masakan = it) { masakanId ->
                    navController.navigate("${Screen.Detail.route}/$masakanId")
                }
            }
        }
    }
}

