package com.omergezici.yemeklerbitirmeprojesi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omergezici.yemeklerbitirmeprojesi.data.entity.CRUDCevap
import com.omergezici.yemeklerbitirmeprojesi.data.repo.YemeklerRepository
import kotlinx.coroutines.launch

class UrunDetayViewModel (var krepo : YemeklerRepository) : ViewModel() {
val yeniYemek=MutableLiveData<CRUDCevap>()
    fun sepeteEkleme(yemek_isim: String,yemek_resim_adi:String,yemek_fiyat :String,yemek_siparis_adet:String){

    }
}