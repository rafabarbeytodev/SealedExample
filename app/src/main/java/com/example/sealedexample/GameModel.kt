package com.example.sealedexample

/*****
 * Proyect: SealedExample
 * Package: com.example.sealedexample
 *
 * Created by Rafael Barbeyto Torrellas on 20/02/2023 at 12:18
 * More info: https://www.linkedin.com/in/rafa-barbeyto/
 *
 * All rights reserved 2023.
 *****/
data class GameModel(
    val title: String,
    val serialNumber:String,
    val error:GameError
)

sealed class GameError(){
    //Los objetos de las Sealed class suelen empezar con mayusculas
    object DeprecatedError: GameError()
    object InternetError: GameError()
    object NoError: GameError()
    object FrozenError: GameError()
    data class VersionError(val version:String): GameError() //Este error depende de la versión de la app
}