package com.example.whowantstobemillionaire.ui.game

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.whowantstobemillionaire.R
import com.example.whowantstobemillionaire.databinding.FragmentGameBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGameBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var correct_answer = 5

        viewModel.questionFlow.onEach {
            with(binding) {
                checkReward(it.numberQuestion)

                tvQuestion.text = it.question
                buttonA.text = "A: ${it.answerA}"
                buttonB.text = "B: ${it.answerB}"
                buttonC.text = "C: ${it.answerC}"
                buttonD.text = "D: ${it.answerD}"
                correct_answer = it.correctAnswer
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        binding.buttonA.setOnClickListener {
            checkAnswer(1, correct_answer)
        }

        binding.buttonB.setOnClickListener {
            checkAnswer(2, correct_answer)
        }

        binding.buttonC.setOnClickListener {
            checkAnswer(3, correct_answer)
        }

        binding.buttonD.setOnClickListener {
            checkAnswer(4, correct_answer)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkAnswer(answer: Int, correct: Int) {
        if(answer == correct) {
            viewModel.sendAnswer()
        } else {
            showDialog("Вы проиграли")?.show()
        }
    }

    private fun checkReward(numberQuestion: Int) {
        when (numberQuestion) {
            2 -> {
                binding.tvReward1.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward2.background = resources.getDrawable(R.drawable.reward_style_ready)
            }
            3 -> {
                binding.tvReward2.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward3.background = resources.getDrawable(R.drawable.reward_style_ready)
            }
            4 -> {
                binding.tvReward3.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward4.background = resources.getDrawable(R.drawable.reward_style_ready)
            }
            5 -> {
                binding.tvReward4.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward5.background = resources.getDrawable(R.drawable.reward_style_ready)
            }
            6 -> {
                binding.tvReward5.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward6.background = resources.getDrawable(R.drawable.reward_style_ready)
            }
            7 -> {
                binding.tvReward6.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward7.background = resources.getDrawable(R.drawable.reward_style_ready)
            }
            8 -> {
                binding.tvReward7.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward8.background = resources.getDrawable(R.drawable.reward_style_ready)
            }
            9 -> {
                binding.tvReward8.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward9.background = resources.getDrawable(R.drawable.reward_style_ready)
            }
            10 -> {
                binding.tvReward9.background = resources.getDrawable(R.drawable.reward_style_done)
                binding.tvReward10.background = resources.getDrawable(R.drawable.reward_style_ready)
                showDialog("Вы победили")?.show()
            }
        }
    }

    private fun showDialog(msg: String): AlertDialog? {
        return AlertDialog.Builder(requireContext())
            .setMessage(msg)
            .setPositiveButton("Выйти") { dialog, _ ->
                dialog.cancel()
                findNavController().navigate(R.id.action_gameFragment_to_menuFragment)
            }
            .create()
    }

}