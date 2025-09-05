package com.motorola.edgenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.motorola.edgenotes.presentation.theme.EdgeNotesTheme
import androidx.compose.material3.Surface
import dagger.hilt.android.AndroidEntryPoint
import com.motorola.edgenotes.presentation.navigation.EdgeNotesNavHost

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdgeNotesTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    EdgeNotesNavHost()
                }
            }
        }
    }
}
