package com.omeriyioz.github_android.features

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.FollowTheSigns
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.omeriyioz.github_android.features.fragment1.RepoScreen
import com.omeriyioz.github_android.features.fragment1.ViewModel1
import com.omeriyioz.github_android.features.fragment2.SearchUserScreen
import com.omeriyioz.github_android.features.fragment2.ViewModel2
import com.omeriyioz.github_android.features.fragment3.FollowsScreen

@Composable
fun BottomNavGraph(navController: NavHostController, searchedUsername: String) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItem.Repo.route
    ) {
        composable(route = BottomBarItem.Repo.route) {
            val viewModel1 = hiltViewModel<ViewModel1>()
            RepoScreen(viewModel1, searchedUsername)
        }
        composable(route = BottomBarItem.User.route) {
            val viewModel2 = hiltViewModel<ViewModel2>()
            SearchUserScreen(viewModel2, searchedUsername)
        }
        composable(route = BottomBarItem.Settings.route) {
            FollowsScreen(searchedUsername = searchedUsername)
        }
    }
}

sealed class BottomBarItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Repo : BottomBarItem(
        route = "repo",
        title = "Repo",
        icon = Icons.Default.Archive
    )

    object User : BottomBarItem(
        route = "user",
        title = "User",
        icon = Icons.Default.Person
    )

    object Settings : BottomBarItem(
        route = "follow",
        title = "Follow",
        icon = Icons.Default.FollowTheSigns
    )
}
