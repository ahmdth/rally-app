package com.example.rallyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rallyapp.ui.components.RallyTabRow
import com.example.rallyapp.ui.theme.RallyAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RallyAppTheme {
                val navController = rememberNavController()
                val currentBackStack by navController.currentBackStackEntryAsState()
                val currentDestination = currentBackStack?.destination
                val currentScreen =
                    rallyTabRowScreens.find { it.route == currentDestination?.route } ?: Overview

                Scaffold(
                    topBar = {
                        RallyTabRow(
                            allScreens = rallyTabRowScreens,
                            onTabSelected = { newScreen ->
                                navController.navigateSingleTopTo(newScreen.route)
                            },
                            currentScreen = currentScreen
                        )
                    }
                ) { innerPadding ->
                    RallyNavHost(
                        navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

