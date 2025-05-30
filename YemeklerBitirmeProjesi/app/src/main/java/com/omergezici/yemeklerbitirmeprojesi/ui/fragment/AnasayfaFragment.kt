package com.omergezici.yemeklerbitirmeprojesi.ui.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.omergezici.yemeklerbitirmeprojesi.R
import com.omergezici.yemeklerbitirmeprojesi.data.datasource.YemeklerDataSource
import com.omergezici.yemeklerbitirmeprojesi.data.entity.YemeklerAnasayfa
import com.omergezici.yemeklerbitirmeprojesi.data.repo.YemeklerRepository
import com.omergezici.yemeklerbitirmeprojesi.databinding.FragmentAnasayfaBinding
import com.omergezici.yemeklerbitirmeprojesi.ui.adapter.YemekAnasayfaAdapter
import com.omergezici.yemeklerbitirmeprojesi.ui.viewmodel.AnasayfaViewModel




class AnasayfaFragment : Fragment() {
  private lateinit var viewModel:AnasayfaViewModel
 private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAnasayfaBinding.inflate(inflater,container,false)
        val dataSource=YemeklerDataSource()
        val repo=YemeklerRepository(dataSource)
        viewModel=ViewModelProvider(this,object :ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return AnasayfaViewModel(repo) as T
            }
        }).get(AnasayfaViewModel::class.java)

        val adapter=YemekAnasayfaAdapter(requireContext(), listOf(),viewModel)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        viewModel.yemeklerListesi.observe(viewLifecycleOwner){ liste ->
            liste?.let {
                adapter.yemeklerAnasayfaListe = it
                adapter.notifyDataSetChanged()
            }
        }
        viewModel.yemekleriYukle()
        binding.floatingActionButtonSepet.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sepeteGecis)
        }

        return binding.root
    }
    override fun onResume() {
        super.onResume()
        viewModel.yemekleriYukle()
    }

}