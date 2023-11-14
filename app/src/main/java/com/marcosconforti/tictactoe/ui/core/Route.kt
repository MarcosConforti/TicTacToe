package com.marcosconforti.tictactoe.ui.core

sealed class Route(val route:String){
    object Home:Route("home")
    object Game:Route("game/{gameId}/{userId}/{owner}"){
        fun createRoute(gameId:String,userId:String,owner:Boolean):String{
            return "game/$gameId/$userId/$owner"
        }
    }

}
