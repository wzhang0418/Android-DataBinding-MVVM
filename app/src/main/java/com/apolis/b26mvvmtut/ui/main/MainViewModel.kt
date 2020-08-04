package com.apolis.b26mvvmtut.ui.main

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.apolis.b26mvvmtut.api.ApiClient
import com.hb.b26mvvmtut.generated.callback.OnClickListener

class MainViewModel : ViewModel() { //Business logic

    private val mainRepository = MainRepository(ApiClient.getApiEndPoint())
    private var buttonCounter = 0

    fun getGithubRepositoryObserver() = mainRepository.listGithubRepository

    /**
     * This method is called when [MainActivity] button will clicked.
     * ALso is used to wait for x seconds and update the UI
     */
    fun onButtonClicked() {
        ++buttonCounter
        mainRepository.getDataFromApi()
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("MainViewModel", "Destroyed")
    }
}