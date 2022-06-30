package com.example.whowantstobemillionaire.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
            .show()
    }

    private fun checkAnswer(answer: Int, correct: Int) {
        if(answer == correct) {
            showToast("Correct")
            viewModel.sendAnswer()
        } else {
            showToast("Incorrect")
        }
    }
}