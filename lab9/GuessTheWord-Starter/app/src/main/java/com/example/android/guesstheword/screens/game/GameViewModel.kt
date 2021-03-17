package com.example.android.guesstheword.screens.game

import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel: ViewModel() {

    // The current word
    var word = ""

    // The current score
    var score = 0

    private lateinit var wordList: MutableList<String>
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }
    init {
        resetList()
        nextWord()
        Timber.i("GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed!")
    }
    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }
    }


}