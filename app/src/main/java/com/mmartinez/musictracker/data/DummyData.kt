package com.mmartinez.musictracker.data

import com.mmartinez.musictracker.data.model.MusicModel

val genre = "Hip Hop"
val instruments = "Bajo y Teclado"

val genre2 = "Rock N Roll"
val instruments2 = "Guitarra y Bateria"

var allMusic = mutableListOf(
    MusicModel(genre, instruments),
    MusicModel(genre2, instruments2)
)
