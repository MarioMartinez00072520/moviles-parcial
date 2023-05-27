package com.mmartinez.musictracker.ui.music.newmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mmartinez.musictracker.R
import com.mmartinez.musictracker.databinding.FragmentNewMusicBinding

class NewMusicFragment : Fragment() {
    private val newMusicViewModel: NewMusicViewModel by viewModels{
        NewMusicViewModel.Factory
    }
    private lateinit var binding: FragmentNewMusicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewMusicBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun setViewModel(){
        binding.viewmodel = newMusicViewModel
    }


}