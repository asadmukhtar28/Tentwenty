package com.asad.tentwenty.ui.main.watch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asad.tentwenty.data.remote.models.movie.MovieModel
import com.asad.tentwenty.databinding.ItemUpcomingMoviesBinding
import com.asad.tentwenty.interfaces.AdapterUpdateListener
import com.asad.tentwenty.interfaces.OnItemClickListener
import com.asad.tentwenty.ui.base.BaseViewHolder
import javax.inject.Inject

class UpComingMoviesAdapter @Inject constructor() :
    RecyclerView.Adapter<UpComingMoviesAdapter.ItemViewHolder>(),
    AdapterUpdateListener<MovieModel> {
    val movieList = ArrayList<MovieModel>()
    var listener: OnItemClickListener? = null

    fun setItemListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemUpcomingMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun clearItems() {
        movieList.clear()
        notifyDataSetChanged()
    }

    override fun addItems(items: List<MovieModel>, isLoadMore: Boolean) {
        if (!isLoadMore) {
            clearItems()
            movieList.addAll(items as Collection<MovieModel>)
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(val binding: ItemUpcomingMoviesBinding) :
        BaseViewHolder(binding.root), UpComingMoviesItemViewModel.OnItemClickListener {
        override fun onBind(position: Int) {
            binding.viewModel = UpComingMoviesItemViewModel(movieList[position], this)
            binding.executePendingBindings()
        }

        override fun onItemClick() {
            listener?.onItemClick(movieList[adapterPosition])
        }
    }
}