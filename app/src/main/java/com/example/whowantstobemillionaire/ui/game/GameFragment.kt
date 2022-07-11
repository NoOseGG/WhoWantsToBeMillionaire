package com.example.whowantstobemillionaire.ui.game

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.whowantstobemillionaire.R
import com.example.whowantstobemillionaire.databinding.FragmentGameBinding
import com.example.whowantstobemillionaire.model.Question
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: GameViewModel by viewModels()

    private val rewards by lazy {
        listOf(binding.tvReward1, binding.tvReward2, binding.tvReward3, binding.tvReward4, binding.tvReward5,
            binding.tvReward6, binding.tvReward7, binding.tvReward8, binding.tvReward9, binding.tvReward10)
    }

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

        //button hint click
        binding.btnHintCall.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setMessage("Кому Вы хотете позвонить?")
                .setPositiveButton("Денису Кононовичу") {dialog, id ->
                    viewModel.sendWhoCalled(id)
                    dialog.dismiss()
                }
                .create()
                .show()
        }

        viewModel.hintFlow.onEach {
            Toast.makeText(requireContext(), "$it $correct_answer", Toast.LENGTH_LONG).show()
            binding.btnHintCall.isEnabled = false
            binding.btnHintCall.background = ResourcesCompat.getDrawable(resources, R.drawable.button_hint_disable_style, null)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
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
            in 2..10 -> {
                rewards[numberQuestion - 2].background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                rewards[numberQuestion - 1].background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_ready, null)
            }
            11 -> {
                rewards[numberQuestion - 2].background = ResourcesCompat.getDrawable(resources, R.drawable.reward_style_done, null)
                showDialog("Вы победили")?.show()
            }
        }
    }

    private fun showDialog(msg: String): AlertDialog? {
        return AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setMessage(msg)
            .setPositiveButton("Выйти") { dialog, _ ->
                dialog.dismiss()
                findNavController().navigate(R.id.action_gameFragment_to_menuFragment)
            }
            .create()
    }

}