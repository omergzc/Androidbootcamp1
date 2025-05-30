package com.omergezici.yemeklerbitirmeprojesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omergezici.yemeklerbitirmeprojesi.R
import com.omergezici.yemeklerbitirmeprojesi.data.entity.YemeklerAnasayfa
import com.omergezici.yemeklerbitirmeprojesi.databinding.CardTasarimAnasayfaBinding
import com.omergezici.yemeklerbitirmeprojesi.ui.fragment.AnasayfaFragmentDirections
import com.omergezici.yemeklerbitirmeprojesi.ui.viewmodel.AnasayfaViewModel

class YemekAnasayfaAdapter(var mcontext:Context, var yemeklerAnasayfaListe:List<YemeklerAnasayfa> = listOf(), private var viewModel: AnasayfaViewModel):RecyclerView.Adapter<YemekAnasayfaAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:CardTasarimAnasayfaBinding):RecyclerView.ViewHolder(tasarim.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
   val  binding=CardTasarimAnasayfaBinding.inflate(LayoutInflater.from(mcontext),parent,false)
        return CardTasarimTutucu(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
       val yemek=yemeklerAnasayfaListe.get(position)
        val t=holder.tasarim
        t.textViewUcret.text="₺ ${yemek.yemek_fiyat}"
        t.textViewAnasayfaYemek.text=yemek.yemek_adi
        resimGoster(yemek.yemek_resim_adi, t)
        t.imageViewYemekAnasayfa.setOnClickListener{
            val gecis=AnasayfaFragmentDirections.detayaGecis(Yemek = yemek)

            Navigation.findNavController(it).navigate(gecis)

        }

        t.imageViewYemekAnasayfa.setOnClickListener{
            val transition=AnasayfaFragmentDirections.detayaGecis(yemek)
            Navigation.findNavController(it).navigate(transition)
        }


    }


    override fun getItemCount(): Int {
        return yemeklerAnasayfaListe.size
    }
    fun resimGoster(resim_isim:String,binding: CardTasarimAnasayfaBinding){
        val url=("http://kasimadalan.pe.hu/yemekler/resimler/$resim_isim")
        Glide.with(mcontext).load(url).override(300,300).into(binding.imageViewYemekAnasayfa)

    }
}