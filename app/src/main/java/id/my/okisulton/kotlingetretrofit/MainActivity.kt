package id.my.okisulton.kotlingetretrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import id.my.okisulton.kotlingetretrofit.model.Data
import id.my.okisulton.kotlingetretrofit.model.Reqres
import id.my.okisulton.kotlingetretrofit.retrofit.ApiClient
import id.my.okisulton.kotlingetretrofit.retrofit.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    private val dataList: MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setup adapter
        myAdapter = MyAdapter(dataList)

        //setup recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, OrientationHelper.HORIZONTAL))
        recyclerView.adapter = myAdapter

    }

    override fun onStart() {
        super.onStart()
        getReqres()
    }

    private fun getReqres() = ApiClient.getData()
        .create(ApiInterface::class.java).getUser()
        ?.enqueue(object: Callback<Reqres>{
            override fun onResponse(call: Call<Reqres>, response: Response<Reqres>) {
                dataList.addAll(response.body()!!.data)
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Reqres>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
}
