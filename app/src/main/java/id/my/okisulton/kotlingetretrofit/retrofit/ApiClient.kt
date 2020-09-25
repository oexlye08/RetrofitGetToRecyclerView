package id.my.okisulton.kotlingetretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *Created by osalimi on 25-09-2020.
 **/
object ApiClient {
    val BASE_URL = "https://reqres.in/api/"
    var retrofit: Retrofit? = null
    fun getData(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}