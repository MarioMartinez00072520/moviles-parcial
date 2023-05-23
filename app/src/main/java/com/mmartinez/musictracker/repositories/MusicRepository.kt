package com.mmartinez.musictracker.repositories

import com.mmartinez.musictracker.data.model.MusicModel

class MusicRepository(private val music: MutableList<MusicModel>) {
    fun getMusic() = music

    fun addMusic(musicParam: MusicModel) = music.add(musicParam)
}