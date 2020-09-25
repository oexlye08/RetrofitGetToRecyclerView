package id.my.okisulton.kotlingetretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.my.okisulton.kotlingetretrofit.model.Data
import kotlinx.android.synthetic.main.item_list.view.*

/**
 *Created by osalimi on 25-09-2020.
 **/
class MyAdapter(private  val dataList: MutableList<Data>): RecyclerView.Adapter<MyHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]

        val UserFullName = holder.itemView.textView
        val UserAvatar = holder.itemView.imageView

        val fullname = "${data.firstName} ${data.lastName}"
        UserFullName.text = fullname.toString()
        
        Picasso.get()
            .load(data.avatar)
            .into(UserAvatar)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, fullname, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
