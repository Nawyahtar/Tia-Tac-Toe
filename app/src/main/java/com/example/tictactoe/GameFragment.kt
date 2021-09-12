package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.tictactoe.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding:FragmentGameBinding
    var activePlayer = 1
    var gameIsActive = true
    var count = 0
    var gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var winningPositions = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)
        binding.imageView1.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.imageView2.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.imageView3.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.imageView4.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.imageView5.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.imageView6.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.imageView7.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.imageView8.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.imageView9.setOnClickListener(View.OnClickListener {
            click(it)
        })
        binding.playAgain.setOnClickListener(View.OnClickListener {
            playAgain(it)
        })
        return binding.root
    }
    fun click(view: View) {
        val counter = view as ImageView
         val tappedcounter = counter.tag.toString().toInt()
        if (gameState[tappedcounter] == 2 && gameIsActive) {
            if (activePlayer == 1) {
                counter.setImageResource(R.drawable.x)
                activePlayer = 0
                count++
                gameState[tappedcounter] = 1
            } else {
                counter.setImageResource(R.drawable.circle)
                activePlayer = 1
                count++
                gameState[tappedcounter] = 0
            }

            for (winningposition in winningPositions) {
                if (gameState[winningposition[0]] == gameState[winningposition[1]] && gameState[winningposition[1]] == gameState[winningposition[2]] && gameState[winningposition[0]] != 2
                ) {
                    if (gameState[winningposition[0]] == 0)  binding.winner1.text =
                        "O Player Wins" else if (gameState[winningposition[0]] == 1
                    ) binding.winner1.text = "X Player Wins"
                    binding.winner.visibility = View.VISIBLE
                    gameIsActive = false
                }
            }
        }
        if (gameIsActive && count == 9) {
            binding.winner1.text = "DRAW"
            binding.winner.visibility = View.VISIBLE
            gameIsActive = false
        }
    }

    fun playAgain(view: View?) {
        activePlayer = 1
        gameIsActive = true
        count= 0
        for (i in gameState.indices) {
            gameState[i] = 2
        }
        binding.winner.visibility = View.INVISIBLE
        for (i in 0 until binding.gridLayout.childCount) {
            (binding.gridLayout.getChildAt(i) as ImageView).setImageResource(0) //p t n
        }
    }

}