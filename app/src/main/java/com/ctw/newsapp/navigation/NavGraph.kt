package com.ctw.newsapp.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.core.os.bundleOf
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ctw.model.Article
import com.ctw.newsapp.ui.details.NewsDetails
import com.ctw.newsapp.ui.extensions.toArticle
import com.ctw.newsapp.ui.extensions.toBundle
import com.ctw.newsapp.ui.healines.Headlines
import org.koin.androidx.compose.getViewModel

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = Screen.MainScreen.route
) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(Screen.MainScreen.route) {
            Headlines(getViewModel()) {
                val destination = navController.graph.findNode(Screen.NewsDetailsScreen.route)
                if (destination != null) {
                    navController.navigate(destination.id, it.toBundle())
                }
            }
        }
        composable(Screen.NewsDetailsScreen.route) {
            NewsDetails(
                it.arguments?.toArticle(),
                onBackPress = { navController.popBackStack() }
            )
        }
    }
}