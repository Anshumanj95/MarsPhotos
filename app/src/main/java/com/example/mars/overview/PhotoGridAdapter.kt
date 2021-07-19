package com.example.mars.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mars.databinding.GridViewItemBinding
import com.example.mars.network.MarsPhotos

class PhotoGridAdapter:ListAdapter<MarsPhotos,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.MarsPhotoViewHolder {
       return MarsPhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }



    override fun onBindViewHolder(holder: PhotoGridAdapter.MarsPhotoViewHolder, position: Int) {
        val marsPhoto=getItem(position)
        holder.bind(marsPhoto)
    }
    class MarsPhotoViewHolder(private val binding:GridViewItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto:MarsPhotos){
            binding.photo=MarsPhoto
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback:DiffUtil.ItemCallback<MarsPhotos>(){
        override fun areItemsTheSame(oldItem: MarsPhotos, newItem: MarsPhotos): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhotos, newItem: MarsPhotos): Boolean {
            return oldItem.imgSrcUrl==newItem.imgSrcUrl
        }

    }
}