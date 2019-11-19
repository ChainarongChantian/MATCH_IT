package com.example.android.navigation.game

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.example.android.navigation.Fruit
import com.example.android.navigation.R
import timber.log.Timber
import java.util.*
import kotlin.concurrent.schedule

class GameViewModel(var username: String, var gameScore: Int, var timeSpent: Int): ViewModel() {

    //            Fruit(name = "box", nameToInt = 2131165288),
    //            Fruit(name = "coconut", nameToInt = 2131165289),
    //            Fruit(name = "passion_fruit", nameToInt = 2131165300),
    //            Fruit(name = "pomegranate", nameToInt = 2131165301),
    //            Fruit(name = "orange", nameToInt = 2131165299),
    //            Fruit(name = "lime", nameToInt = 2131165295),
    //            Fruit(name = "kiwi", nameToInt = 2131165292),
    //            Fruit(name = "guava", nameToInt = 2131165291),
    //            Fruit(name = "grapefruit", nameToInt = 2131165290),
    var gameTimer: GameTimer

    init {

        Timber.i("timer init")
        gameTimer = GameTimer()
    }

    override fun onCleared() {

        super.onCleared()
        Timber.i("GameViewModel destroyed!!")
    }

    fun calculateScore(periodChoose: Int) {

        gameScore += when {
            periodChoose < 2 -> 12
            periodChoose < 3 -> 8
            periodChoose < 5 -> 4
            periodChoose < 6 -> 2
            else  -> 1
        }

        //EXTRA
        gameScore += when (gameScore) {
            96 -> 4
            else -> 0
        }
    }

    fun onStart() {

        gameTimer.startTimer()
    }

    fun onStop() {
        gameTimer.stopTimer()
    }
}