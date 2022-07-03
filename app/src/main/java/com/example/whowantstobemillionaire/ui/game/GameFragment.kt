package com.example.whowantstobemillionaire.ui.game

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
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

        var correct_answer = 0

        viewModel.questionFlow.onEach {
            with(binding) {
                checkReward(it.numberQuestion)

                tvQuestion.text = it.question
                buttonA.text = getString(R.string.answer_a, it.answerA)
                buttonB.text = getString(R.string.answer_b, it.answerB)
                buttonC.text = getString(R.string.answer_c, it.answerC)
                buttonD.text = getString(R.string.answer_d, it.answerD)
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
                binding.tvReward1.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward2.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            3 -> {
                binding.tvReward2.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward3.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            4 -> {
                binding.tvReward3.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward4.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            5 -> {
                binding.tvReward4.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward5.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            6 -> {
                binding.tvReward5.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward6.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            7 -> {
                binding.tvReward6.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward7.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            8 -> {
                binding.tvReward7.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward8.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            9 -> {
                binding.tvReward8.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward9.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            10 -> {
                binding.tvReward9.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                binding.tvReward10.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            11 -> {
                binding.tvReward10.background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
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