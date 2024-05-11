package com.example.tugas_lord_sepuh_rehan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugas_lord_sepuh_rehan.component.IndomieItem
import com.example.tugas_lord_sepuh_rehan.data.MieData
import com.example.tugas_lord_sepuh_rehan.model.Indomie
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tugas_lord_sepuh_rehan.component.IndomieItem
import com.example.tugas_lord_sepuh_rehan.component.MerkItem
import com.example.tugas_lord_sepuh_rehan.model.Merk

import com.example.tugas_lord_sepuh_rehan.navigation.NavigationItem

@Composable
fun Home(
    navController: NavController,
    modifier: Modifier = Modifier,
    indomies: List<Indomie> = MieData.mieIndomie,
    merks: List<Merk> = MieData.merkMie,
) {
    Surface(
        color = Color(0xF1F1F1F1),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier) {
            LazyRow(
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(merks, key = { it.id }) {
                    MerkItem(merk = it)
                }
            }
            LazyVerticalGrid(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                columns = GridCells.Adaptive(140.dp),
                modifier = modifier.fillMaxSize()
            ) {
                items(indomies, key = { it.id }) {
                    IndomieItem(indomie = it)
                }
            }
        }
    }
}