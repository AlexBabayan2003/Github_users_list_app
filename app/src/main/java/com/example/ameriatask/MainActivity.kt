package com.example.ameriatask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ameriatask.userdetailsscreen.UserDetailScreen
import com.example.ameriatask.userscreen.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController:NavHostController = rememberNavController()
            NavHost(navController = navController, startDestination = "userList") {
                composable("userList") {
                    UserListScreen(navController)
                }
                composable("userDetails/{username}") { backStackEntry ->
                    val username = backStackEntry.arguments?.getString("username") ?: ""
                    UserDetailScreen(username)
                }
            }
        }
    }
}
