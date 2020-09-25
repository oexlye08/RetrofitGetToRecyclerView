package id.my.okisulton.kotlingetretrofit.retrofit

import id.my.okisulton.kotlingetretrofit.model.Reqres
import retrofit2.Call
import retrofit2.http.GET

/**
 *Created by osalimi on 25-09-2020.
 **/
interface ApiInterface {
    @GET("users?page=2")
    fun getUser(): Call<Reqres>
}