package com.mmartinez.musictracker.ui.music.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mmartinez.musictracker.MusicTrackerApplication
import com.mmartinez.musictracker.data.model.MusicModel
import com.mmartinez.musictracker.repositories.MusicRepository

class HomeViewModel(private val repository: MusicRepository): ViewModel(){

    var genre = MutableLiveData("")
    var instruments = MutableLiveData("")

    fun getMusic() = repository.getMusic()

    fun setSelectedMusic(music: MusicModel){
        genre.value = music.genre
        instruments.value = music.instruments
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app =
                    this[APPLICATION_KEY] as MusicTrackerApplication
                    HomeViewModel(app.musicRepository)
            }
        }
    }
}