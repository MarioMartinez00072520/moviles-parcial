package com.mmartinez.musictracker.ui.music.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmartinez.musictracker.data.model.MusicModel
import com.mmartinez.musictracker.databinding.MusicItemBinding

class MusicRecyclerViewAdapter(
    private val clickListener: (MusicModel) -> Unit
    ) : RecyclerView.Adapter<MusicRecyclerViewHolder>(){

    private val music = ArrayList<MusicModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicRecyclerViewHolder {
        val binding = MusicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return music.size
    }

    override fun onBindViewHolder(holder: MusicRecyclerViewHolder, position: Int) {
        val musicBinded = music[position]
        holder.bind(musicBinded, clickListener)
    }

    fun setData(musicList: List<MusicModel>){
        music.clear()
        music.addAll(musicList)
    }
}