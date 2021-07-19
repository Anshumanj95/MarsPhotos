package com.example.mars

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mars.network.MarsPhotos
import com.example.mars.overview.MarsApiStatus
import com.example.mars.overview.PhotoGridAdapter


@BindingAdapter("imgUrl")
    fun bindImage(imgView: ImageView,imgUrl:String?){
        imgUrl?.let {
            val imgUri=imgUrl.toUri().buildUpon().scheme("https").build()
            imgView.load(imgUri){
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
            }
        }

    }
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data:List<MarsPhotos>?){
    val adapter=recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView,status:MarsApiStatus){
    when(status){
        MarsApiStatus.LOADING->{
            statusImageView.visibility=View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.ERROR->{
            statusImageView.visibility=View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MarsApiStatus.SUCCESS->{
            statusImageView.visibility=View.INVISIBLE
        }
    }
}
