package com.motorola.edgenotes

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.motorola.edgenotes.presentation.notes.detail.NoteDetailScreen
import com.motorola.edgenotes.presentation.notes.list.NotesListScreen

@Composable
fun NotesApp() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "list") {
            composable("list") {
                NotesListScreen(onAddNote = { navController.navigate("detail") })
            }
            composable("detail") {
                NoteDetailScreen()
            }
        }
    }
}
