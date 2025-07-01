package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myfirstcomposeapp.components.model.NavItem

@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {
    val itemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Favorite", Icons.Default.Favorite),
        NavItem("Profile", Icons.Default.Person),
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    NavigationBar {

        itemList.forEachIndexed { index, item ->
            ManuNavItem(
                item,
                isSelected = (index == selectedIndex),
                onClick = { selectedIndex = index })
        }
    }
}

@Composable
fun RowScope.ManuNavItem(navItem: NavItem, isSelected: Boolean, onClick: (() -> Unit)? = null) {
    NavigationBarItem(
        selected = isSelected,
        onClick = { onClick?.invoke() },
        icon = {
            Icon(
                imageVector = navItem.icon,
                contentDescription = ""
            )
        },
        label = { Text(navItem.name) },
        alwaysShowLabel = false
    )
}