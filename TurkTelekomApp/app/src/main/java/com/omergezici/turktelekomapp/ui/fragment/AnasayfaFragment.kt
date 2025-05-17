package com.omergezici.turktelekomapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.omergezici.turktelekomapp.R
import com.omergezici.turktelekomapp.data.entitity.etkinlikler
import com.omergezici.turktelekomapp.databinding.FragmentAnasayfaBinding
import com.omergezici.turktelekomapp.ui.adapter.EtkinliklerAdapter

class AnasayfaFragment : Fragment() {
private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAnasayfaBinding.inflate(inflater,container,false)
        val eList=ArrayList<etkinlikler>()
        val e1 =etkinlikler(1, "edergikesfet", "e-dergi Keşfet")
        val e2=etkinlikler(2,"edergimother","e-dergi Anneler Günü")
        val e3=etkinlikler(3,"ekpaketler","Ek Paketler")
        val e4=etkinlikler(4,"jetders","JetDers'te Neler Var?")
        val e5=etkinlikler(5,"mother","Anneler Günü")
        val e6=etkinlikler(6,"muud","Muud - En Yeniler")
        val e7=etkinlikler(7,"tivibublutv","Blutv")
        eList.add(e1)
        eList.add(e2)
        eList.add(e3)
        eList.add(e4)
        eList.add(e5)
        eList.add(e6)
        eList.add(e7)


        val EAdapter=EtkinliklerAdapter(requireContext(),eList)
        binding.recyclerViewEtkinlikler.adapter=EAdapter
        binding.recyclerViewEtkinlikler.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)











        return binding.root
    }

}