package com.mmartinez.musictracker.ui.music.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mmartinez.musictracker.MusicTrackerApplication
import com.mmartinez.musictracker.data.model.MusicModel
import com.mmartinez.musictracker.repositories.MusicRepository

class MusicViewModel(private val repository: MusicRepository): ViewModel() {
    var genre = MutableLiveData("")
    var instruments = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMusic() = repository.getMusic()

    fun addMusic(musicParam : MusicModel) = repository.addMusic(musicParam)

    fun createMusic() {
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val music = MusicModel(
            genre.value!!,
            instruments.value!!
        )

        addMusic(music)
        clearData()

        status.value = MUSIC_CREATED
    }

    private fun validateData(): Boolean {
        when{
            genre.value.isNullOrEmpty() -> return false
            instruments.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        genre.value = ""
        instruments.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedMusic(music : MusicModel){
        genre.value = music.genre
        instruments.value = music.instruments
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this [APPLICATION_KEY] as MusicTrackerApplication
                MusicViewModel(app.musicRepository)
            }
        }

        const val MUSIC_CREATED = "Music Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }

}