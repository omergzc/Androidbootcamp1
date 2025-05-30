package com.omergezici.yemeklerbitirmeprojesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omergezici.yemeklerbitirmeprojesi.data.entity.YemeklerSepet
import com.omergezici.yemeklerbitirmeprojesi.databinding.CardTasarimAnasayfaBinding
import com.omergezici.yemeklerbitirmeprojesi.databinding.CardTasarimSepetimBinding

class YemeklerSepetAdapter(var mContext: Context,var YemeklerSepetListe:List<YemeklerSepet>):RecyclerView.Adapter<YemeklerSepetAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim : CardTasarimSepetimBinding):RecyclerView.ViewHolder(tasarim.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val tasarim=CardTasarimSepetimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)
    }



    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek=YemeklerSepetListe.get(position)
        val t=holder.tasarim
        t.textViewAdetSayi.text=yemek.yemek_siparis_adet
        t.textViewFiyat.text=yemek.yemek_fiyat
        t.textViewYemekIsim.text=yemek.yemek_adi




    }


    override fun getItemCount(): Int {
        return YemeklerSepetListe.size
    }


}