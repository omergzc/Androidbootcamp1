package com.omergezici.yemeklerbitirmeprojesi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omergezici.yemeklerbitirmeprojesi.data.entity.YemeklerAnasayfa
import com.omergezici.yemeklerbitirmeprojesi.data.repo.YemeklerRepository
import kotlinx.coroutines.launch


class AnasayfaViewModel(var krepo : YemeklerRepository) : ViewModel() {
    val yemeklerListesi = MutableLiveData<List<YemeklerAnasayfa>>()

    init {
        yemekleriYukle()
    }
    fun yemekleriYukle(){
        viewModelScope.launch {
            val yemek=krepo.yemekleriYukle()
            yemeklerListesi.value=yemek
        }
    }
}