package com.omergezici.yemeklerbitirmeprojesi.data.datasource

import android.util.Log
import com.omergezici.yemeklerbitirmeprojesi.data.entity.YemeklerAnasayfa
import com.omergezici.yemeklerbitirmeprojesi.retrofit.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource ( ) {
    suspend fun yemekleriGetir() : List<YemeklerAnasayfa> = withContext(Dispatchers.IO){
        val ydao=ApiUtils.getYemeklerDao()
        val yemeklerListe = ydao.YemekleriYukle()
        val apiYemekler =yemeklerListe.yemekler
        Log.d("API_KONTROL", "Gelen yemek sayısı: ${apiYemekler?.size}")
        Log.d("API_KONTROL", "Yemek listesi içeriği: $apiYemekler")
        return@withContext apiYemekler
    }


}