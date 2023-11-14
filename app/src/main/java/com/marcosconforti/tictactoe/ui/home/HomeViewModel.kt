package com.marcosconforti.tictactoe.ui.home

import androidx.lifecycle.ViewModel
import com.marcosconforti.tictactoe.data.network.FirebaseService
import com.marcosconforti.tictactoe.data.network.data.GameData
import com.marcosconforti.tictactoe.data.network.data.PlayerData
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val firebaseService: FirebaseService) :
    ViewModel() {

    fun onCreateGame(navigateToGame: (String, String, Boolean) -> Unit) {
        val game = createNewGame()
        val gameId = firebaseService.createGame(game)
        val userId = game.player1?.userId!!
        val owner = true
        navigateToGame(gameId, userId, owner)
    }

    fun onJoinGame(gameId: String, navigateToGame: (String, String, Boolean) -> Unit) {
        val owner = false
        navigateToGame(gameId,createUserId(), owner)
    }

    private fun createUserId(): String {
        return Calendar.getInstance().timeInMillis.hashCode().toString()
    }

    private fun createNewGame(): GameData {
        val currentPlayer = PlayerData(playerType = 1)
        return GameData(
            board = List(9) { 0 },
            player1 = currentPlayer,
            player2 = null,
            playerTurn = currentPlayer
        )
    }

}