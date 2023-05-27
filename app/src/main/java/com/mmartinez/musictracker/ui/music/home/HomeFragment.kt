package com.mmartinez.musictracker.ui.music.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmartinez.musictracker.R
import com.mmartinez.musictracker.data.model.MusicModel
import com.mmartinez.musictracker.databinding.FragmentHomeBinding
import com.mmartinez.musictracker.ui.music.home.recyclerview.MusicRecyclerViewAdapter
import com.mmartinez.musictracker.ui.music.newmusic.NewMusicViewModel

class HomeFragment : Fragment() {

    private lateinit var adapter: MusicRecyclerViewAdapter
    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels{
        HomeViewModel.Factory
    }
    private val newMusicViewModel: NewMusicViewModel by viewModels{
        NewMusicViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)
        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_newMusicFragment)
        }
    }

    fun showSelectedItem(music: MusicModel){
        homeViewModel.setSelectedMusic(music)
    }
    fun displayMusic(){
        adapter.setData(homeViewModel.getMusic())
        adapter.notifyDataSetChanged()
    }
    fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = MusicRecyclerViewAdapter{ selectedMusic ->
            showSelectedItem(selectedMusic)
        }
        displayMusic()
    }

}