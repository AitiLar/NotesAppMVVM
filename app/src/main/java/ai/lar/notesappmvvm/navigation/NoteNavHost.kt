package ai.lar.notesappmvvm.navigation

import ai.lar.notesappmvvm.MainViewModel
import ai.lar.notesappmvvm.screens.*
import ai.lar.notesappmvvm.utils.Constants
import ai.lar.notesappmvvm.utils.Constants.Screens.ADD_SCREEN
import ai.lar.notesappmvvm.utils.Constants.Screens.MAIN_SCREEN
import ai.lar.notesappmvvm.utils.Constants.Screens.NOTE_SCREEN
import ai.lar.notesappmvvm.utils.Constants.Screens.START_SCREEN
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class NavRoute(val route: String){
    object Start: NavRoute(START_SCREEN)
    object Main: NavRoute(MAIN_SCREEN)
    object Add: NavRoute(ADD_SCREEN)
    object Note: NavRoute(NOTE_SCREEN)
}

@Composable
fun NoteNavHost(mViewModel: MainViewModel) {
    val navContruller = rememberNavController()
    NavHost(navController = navContruller, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){ StartScreen(navController = navContruller, viewModel = mViewModel)}
        composable(NavRoute.Main.route){ MainScreen(navController = navContruller, viewModel = mViewModel) }
        composable(NavRoute.Add.route){ AddScreen(navController = navContruller, viewModel = mViewModel) }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            NoteScreen(navController = navContruller, viewModel = mViewModel, noteid = backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
    }

}