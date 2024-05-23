package com.phwnam.furnitureshop.bottomNav

import com.phwnam.furnitureshop.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
){
    object Home : BottomBarScreen(
        route = "Home",
        title = "",
        icon = R.drawable.ic_home
    )
    object Favourite : BottomBarScreen(
        route = "Favourite",
        title = "",
        icon = R.drawable.ic_bookmark
    )
    object Notification : BottomBarScreen(
        route = "Notification",
        title = "",
        icon = R.drawable.ic_notification
    )
    object Profile : BottomBarScreen(
        route = "Profile",
        title = "",
        icon = R.drawable.ic_person
    )
}