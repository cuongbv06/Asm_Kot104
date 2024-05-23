package com.phwnam.furnitureshop.bottomNav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.phwnam.furnitureshop.screens.FavouriteScreen
import com.phwnam.furnitureshop.screens.HomeScreen
import com.phwnam.furnitureshop.screens.NotificationScreen
import com.phwnam.furnitureshop.screens.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController,innerPadding: PaddingValues = PaddingValues()){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Favourite.route){
            FavouriteScreen()
        }
        composable(route = BottomBarScreen.Notification.route){
            NotificationScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
    }
}