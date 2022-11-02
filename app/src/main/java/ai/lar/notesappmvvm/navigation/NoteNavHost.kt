package ai.lar.notesappmvvm.navigation

import ai.lar.notesappmvvm.screens.Add
import ai.lar.notesappmvvm.screens.Main
import ai.lar.notesappmvvm.screens.Note
import ai.lar.notesappmvvm.screens.Start
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class NavRoute(val route: String){
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")
}

@Composable
fun NoteNavHost() {
    val navContruller = rememberNavController()
    NavHost(navController = navContruller, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){ Start(navController = navContruller)}
        composable(NavRoute.Main.route){ Main(navController = navContruller) }
        composable(NavRoute.Add.route){ Add(navController = navContruller) }
        composable(NavRoute.Note.route){ Note(navController = navContruller)}
    }

}