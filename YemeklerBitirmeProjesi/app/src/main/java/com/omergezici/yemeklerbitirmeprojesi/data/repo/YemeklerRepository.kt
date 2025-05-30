package com.omergezici.yemeklerbitirmeprojesi.data.repo

import android.util.Log
import com.omergezici.yemeklerbitirmeprojesi.data.datasource.YemeklerDataSource
import com.omergezici.yemeklerbitirmeprojesi.data.entity.YemeklerAnasayfa
import com.omergezici.yemeklerbitirmeprojesi.data.entity.YemeklerSepet


class YemeklerRepository (private val yds: YemeklerDataSource) {
    suspend fun yemekleriYukle():List<YemeklerAnasayfa>{
        val cevap=yds.yemekleriGetir()

    return cevap

    }


}