package com.vrg.audiobookslearning.ui.options

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.vrg.audiobookslearning.R
import com.vrg.audiobookslearning.databinding.FragmentChosenBinding
import com.vrg.audiobookslearning.ui.chosen.ChosenViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SelectionsFragment : Fragment() {

    private var _binding: FragmentChosenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chosenViewModel =
            ViewModelProvider(this).get(ChosenViewModel::class.java)

        _binding = FragmentChosenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        chosenViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}