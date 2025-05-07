package com.omergezici.odev4

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.omergezici.odev4.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAnasayfaBinding.inflate(inflater, container, false)
        binding.buttonA.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sayfaAgecis)
        }
        binding.button3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sayfaXgecis)

        }



        return binding.root
    }
}