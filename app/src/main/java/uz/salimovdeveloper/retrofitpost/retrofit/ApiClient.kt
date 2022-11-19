package uz.salimovdeveloper.retrofitpost.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {

    const val BASE_URL = "https://hvax.pythonanywhere.com/"

    fun getRetrofitService():RetrofitService{
        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return build.create(RetrofitService::class.java)
    }
}