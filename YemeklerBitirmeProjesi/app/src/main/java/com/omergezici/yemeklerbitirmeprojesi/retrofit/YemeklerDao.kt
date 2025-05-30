package com.omergezici.yemeklerbitirmeprojesi.retrofit

import com.omergezici.yemeklerbitirmeprojesi.data.entity.YemeklerCevap
import retrofit2.http.GET


interface YemeklerDao {
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun YemekleriYukle():YemeklerCevap







}