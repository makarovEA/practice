package ci.nsu.moble.main.ui.main

sealed class MainScreen(val route: String) {
    object Screen1 : MainScreen("firstFragment")
    object Screen2 : MainScreen("secondFragment")
    object Screen3 : MainScreen("thirdFragment")
}