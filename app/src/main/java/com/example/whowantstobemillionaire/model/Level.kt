package com.example.whowantstobemillionaire.model

sealed class Level {

    data class One(val level: Int) : Level()
    data class Two(val level: Int) : Level()
    data class Three(val level: Int) : Level()
    data class Four(val level: Int) : Level()
    data class Five(val level: Int) : Level()
    data class Six(val level: Int) : Level()
    data class Seven(val level: Int) : Level()
    data class Eight(val level: Int) : Level()
    data class Nine(val level: Int) : Level()
    data class Ten(val level: Int) : Level()
}