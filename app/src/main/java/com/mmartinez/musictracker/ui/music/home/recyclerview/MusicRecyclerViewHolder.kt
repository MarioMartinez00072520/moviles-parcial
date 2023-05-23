package com.mmartinez.musictracker.ui.music.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.mmartinez.musictracker.data.model.MusicModel
import com.mmartinez.musictracker.databinding.FragmentHomeBinding
import com.mmartinez.musictracker.databinding.MusicItemBinding

class MusicRecyclerViewHolder(private val binding: MusicItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(music: MusicModel, clickListener: (MusicModel)-> Unit){

    }
}