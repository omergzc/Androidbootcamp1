package com.omergezici.turktelekomapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omergezici.turktelekomapp.data.entitity.etkinlikler
import com.omergezici.turktelekomapp.databinding.CartTasarimEtkinliklerBinding

class EtkinliklerAdapter(var mContext:Context,var etkinlikList:List<etkinlikler>):
        RecyclerView.Adapter<EtkinliklerAdapter.cardDesignHolder>()
{
    inner class cardDesignHolder(var design:CartTasarimEtkinliklerBinding):RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardDesignHolder {
        val design = CartTasarimEtkinliklerBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return cardDesignHolder(design)
    }


    override fun onBindViewHolder(holder: cardDesignHolder, position: Int) {
    val etkinlik=etkinlikList.get(position)
        val t=holder.design
        t.textViewEtkinlikYazi.text=etkinlik.etkinlikYazi

        t.imageViewEtkinlikPicture.setImageResource(
            mContext.resources.getIdentifier(etkinlik.etkinlikPicture,"drawable",mContext.packageName)

        )
    }
    override fun getItemCount(): Int {
      return  etkinlikList.size

    }
}
