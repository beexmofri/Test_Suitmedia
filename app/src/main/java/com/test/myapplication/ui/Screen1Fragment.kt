package com.test.myapplication.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.test.myapplication.MainViewModel
import com.test.myapplication.R
import com.test.myapplication.databinding.FragmentScreen1Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class Screen1Fragment : Fragment() {
    private var _binding: FragmentScreen1Binding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentScreen1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btcheck.setOnClickListener {
            val text = binding.etpoli.text.toString()
            if (viewModel.ispalindrome(text)) {
                val alertDialog = AlertDialog.Builder(requireContext())
                alertDialog.apply {
                    setIcon(R.drawable.ic_baseline_warning_24)
                    setTitle("Alert")
                    setMessage("isPalindrome")
                }.create().show()

            } else {

                val alertDialog = AlertDialog.Builder(requireContext())
                alertDialog.apply {
                    setIcon(R.drawable.ic_baseline_warning_24)
                    setTitle("Alert")
                    setMessage("notPalindrome")
                }.create().show()

            }
        }
        binding.btnext1.setOnClickListener {
            findNavController().navigate(R.id.action_screen1Fragment_to_screen2Fragment)
        }
    }
}