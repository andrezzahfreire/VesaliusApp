package com.example.vesalius.fragments.bottonsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.vesalius.R
import com.example.vesalius.SalaViewModel
import com.example.vesalius.databinding.FragmentCriarSalaSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CriarSalaSheet : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentCriarSalaSheetBinding
    private lateinit var salaViewModel: SalaViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
       // salaViewModel = ViewModelProvider(activity).get(S)
        binding.btCriarsalashet.setOnClickListener {
            saveAction()
        }

        binding.btClose.setOnClickListener {
            dismiss()
        }


    }

    private fun saveAction() {
        Toast.makeText(this@CriarSalaSheet.requireContext(),"Sala criada com sucesso",Toast.LENGTH_SHORT).show()
        dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCriarSalaSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


}