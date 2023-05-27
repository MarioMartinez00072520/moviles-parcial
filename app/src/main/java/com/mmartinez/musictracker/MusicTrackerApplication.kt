package com.mmartinez.musictracker

import android.app.Application
import com.mmartinez.musictracker.data.allMusic
import com.mmartinez.musictracker.repositories.MusicRepository

class MusicTrackerApplication: Application() {
    val musicRepository: MusicRepository by lazy{
        MusicRepository(allMusic)
    }
}