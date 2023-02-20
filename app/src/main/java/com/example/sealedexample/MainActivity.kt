package com.example.sealedexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sealedexample.GameError.*

class MainActivity : AppCompatActivity() {

    //Cargamos un serie de datos de una fuente
    private val gameList = listOf(
        GameModel("Mario","099895875857", InternetError),
        GameModel("Mario2","09989587584",DeprecatedError),
        GameModel("Mario3","099895875994",NoError),
        GameModel("Mario4","099895875994",FrozenError),
        GameModel("Mario5","099895875994",VersionError("1.2.0")),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //En función del error cargado hacemos alguna acción concreta
        gameList.forEach{ gameModel ->
            when(gameModel.error){
                InternetError -> gotoSupport()
                NoError -> saleGame()
                DeprecatedError -> deleteGame()
                FrozenError -> checkError()
                //la acción a realizar en este caso dependerá de una versión concreta
                is VersionError -> checkVersion(gameModel.error.version)
            }
        }
    }

    private fun checkVersion(version: String) {
    }

    private fun checkError() {
    }

    private fun saleGame(){
    }

    private fun gotoSupport(){
    }

    private fun deleteGame(){
    }
}