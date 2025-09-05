package com.motorola.edgenotes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.motorola.edgenotes.presentation.notedetail.NoteDetailScreen
import com.motorola.edgenotes.presentation.noteslist.NotesListScreen

@Composable
fun EdgeNotesNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "notes") {
        composable("notes") {
            NotesListScreen(
                onAddNote = { navController.navigate("detail") },
                onNoteClick = { id -> navController.navigate("detail/$id") }
            )
        }
        composable("detail") {
            NoteDetailScreen(onBack = { navController.popBackStack() })
        }
        composable(
            route = "detail/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) {
            NoteDetailScreen(onBack = { navController.popBackStack() })
        }
    }
}
