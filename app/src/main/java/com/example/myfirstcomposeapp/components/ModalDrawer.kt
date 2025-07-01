package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.myfirstcomposeapp.components.model.DrawerItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val drawerItems = listOf(
        DrawerItem("Ejemplo 1", Icons.Default.Home, "3"),
        DrawerItem("Ejemplo 2", Icons.Default.Favorite, "0"),
        DrawerItem("Ejemplo 3", Icons.Default.Person)
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerShape = RoundedCornerShape(0)) {
                drawerItems.forEachIndexed { index, item ->
                    ManuDrawerItem(
                        item = item,
                        isSelected = (index == selectedIndex),
                        onClick = {
                            selectedIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        })
                }
            }
        },
        scrimColor = Color.Red.copy(alpha = 0.7f)
    ) {
        content()
    }
}

@Composable
fun ManuDrawerItem(item: DrawerItem, isSelected: Boolean, onClick: () -> Unit) {
    NavigationDrawerItem(
        label = { Text(item.text) },
        selected = isSelected,
        onClick = { onClick() },
        icon = { Icon(imageVector = item.icon, contentDescription = null) },
        badge = {
            if (!item.badgeText.isNullOrBlank()) {
                Badge { Text(item.badgeText) }} },
        shape = RoundedCornerShape(0)
    )
}