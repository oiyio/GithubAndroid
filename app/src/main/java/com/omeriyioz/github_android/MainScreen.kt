package com.omeriyioz.github_android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.omeriyioz.github_android.features.BottomBarItem
import com.omeriyioz.github_android.features.BottomNavGraph
import com.omeriyioz.github_android.features.SearchInputBox

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        val mainViewModel = hiltViewModel<MainViewModel>()
        val searchedUsername by mainViewModel.searchedUsername.observeAsState(initial = "")

        Column(modifier = Modifier.fillMaxSize()) {
            SearchInputBox(onItemComplete = mainViewModel::setSearchedUsername)

            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color.Black, modifier = Modifier.height(4.dp))
            Spacer(modifier = Modifier.height(8.dp))

            BottomNavGraph(navController = navController, searchedUsername)
        }

    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val listOfBottomScreens = listOf(
        BottomBarItem.Repo,
        BottomBarItem.User,
        BottomBarItem.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        listOfBottomScreens.forEach { screen ->
            AddItem(
                bottomBarItem = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    bottomBarItem: BottomBarItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = bottomBarItem.title)
        },
        icon = {
            Icon(
                imageVector = bottomBarItem.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == bottomBarItem.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(bottomBarItem.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
