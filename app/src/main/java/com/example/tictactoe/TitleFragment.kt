package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tictactoe.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {
    private lateinit var binding:FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)
        binding.buttonPlay.setOnClickListener{
            findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
        return binding.root
    }
}