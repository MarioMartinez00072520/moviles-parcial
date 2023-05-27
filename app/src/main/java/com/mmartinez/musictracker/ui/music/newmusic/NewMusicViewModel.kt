package com.mmartinez.musictracker.ui.music.newmusic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mmartinez.musictracker.MusicTrackerApplication
import com.mmartinez.musictracker.data.model.MusicModel
import com.mmartinez.musictracker.repositories.MusicRepository

class NewMusicViewModel(private val repository: MusicRepository): ViewModel(){

    var genre = MutableLiveData("")
    var instruments = MutableLiveData("")
    var status = MutableLiveData("")

    fun addMusic(musicToAdd: MusicModel) = repository.addMusic(musicToAdd)

    fun createMusic(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val musicToAdd = MusicModel(
            genre.value!!,
            instruments.value!!
        )

        addMusic(musicToAdd)
        clearData()
    }

    fun clearData(){
        genre.value = ""
        instruments.value = ""
    }


    private fun validateData(): Boolean{
        when{
            genre.value.isNullOrEmpty() -> return false
            instruments.value.isNullOrEmpty() -> return false
        }
        return true
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MusicTrackerApplication
                NewMusicViewModel(app.musicRepository)
            }
        }

        const val MUSIC_CREATED = "Music Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""

    }
}