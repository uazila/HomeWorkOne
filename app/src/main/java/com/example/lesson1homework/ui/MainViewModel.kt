package com.example.lesson1homework.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mCounter = 0
    private var mHistory = ""

    var historyLiveData = MutableLiveData<String>()
    var counterLiveData = MutableLiveData<Int>()

    fun increment() {
        mCounter++
        counterLiveData.value = mCounter
        mHistory = "$mHistory\n+"
        historyLiveData.value = mHistory
    }

    fun decrement() {
        mCounter--
        counterLiveData.value = mCounter
        mHistory = "$mHistory\n-"
        historyLiveData.value = mHistory
    }


}