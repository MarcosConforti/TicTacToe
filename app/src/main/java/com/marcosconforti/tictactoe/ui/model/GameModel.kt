package com.marcosconforti.tictactoe.ui.model

import com.marcosconforti.tictactoe.data.network.data.GameData
import com.marcosconforti.tictactoe.data.network.data.PlayerData

data class GameModel(
    val board:List<PlayerType>,
    val gameId:String,
    val player1: PlayerModel,
    val player2: PlayerModel?,
    val playerTurn: PlayerModel,
    val isGameReady:Boolean = false,
    val isMyTurn: Boolean = false
) {


    fun toData(): GameData {
        return GameData(
            board = board.map { it.id },
            gameId = gameId,
            player1 = player1.toData(),
            player2 = player2?.toData(),
            playerTurn = playerTurn.toData()
        )
    }
}

data class PlayerModel(
    val userId:String,
    val playerType:PlayerType
){
    fun toData(): PlayerData {
        return PlayerData(
            userId = userId,
            playerType = playerType.id
        )
    }
}
