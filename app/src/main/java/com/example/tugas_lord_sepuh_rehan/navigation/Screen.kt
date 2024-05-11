package com.example.tugas_lord_sepuh_rehan.navigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Museum Indomie")
    object Koleksi : Screen("koleksi", "Koleksi Resep Mie Gotten")
    object About : Screen("about", "About me")
    object Detail : Screen("detail", "Resep Krebi Peti")

    companion object {
        fun fromRoute(route: String?): Screen {
            return when (route) {
                Home.route -> Home
                Koleksi.route -> Koleksi
                About.route -> About
                Detail.route -> Detail
                else -> {
                    if (route?.startsWith("detail/") == true) {
                        Detail
                    } else {
                        throw IllegalArgumentException("salah ngab ga ada route")
                    }
                }
            }
        }
    }
}