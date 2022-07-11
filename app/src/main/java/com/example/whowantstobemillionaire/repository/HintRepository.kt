package com.example.whowantstobemillionaire.repository

import android.app.AlertDialog
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HintRepository @Inject constructor(

) {

    fun hint(id: Int): String {
        when(id) {
            AlertDialog.BUTTON_POSITIVE -> {
                return "Я конечно же редкостный долбаеб, но я думаю что это вариант: "
            }
            AlertDialog.BUTTON_NEGATIVE -> {
                return "ЗАЛУПАААААААААААА"
            }
        }
        return "ffff"
    }
}