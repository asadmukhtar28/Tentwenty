package com.asad.tentwenty.ui.main.watch

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.asad.tentwenty.BR
import com.asad.tentwenty.R
import com.asad.tentwenty.data.remote.models.base.State
import com.asad.tentwenty.data.remote.models.movie.MovieModel
import com.asad.tentwenty.databinding.FragmentWatchBinding
import com.asad.tentwenty.interfaces.OnItemClickListener
import com.asad.tentwenty.ui.base.BaseFragment
import com.asad.tentwenty.ui.detail.MovieDetailActivity
import com.asad.tentwenty.ui.main.watch.adapter.UpComingMoviesAdapter
import com.asad.tentwenty.utils.CommonTags
import com.asad.tentwenty.utils.ItemOffsetDecoration
import com.asad.tentwenty.utils.launchActivity
import com.asad.tentwenty.utils.showShortToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WatchFragment : BaseFragment<WatchViewModel, FragmentWatchBinding>(R.layout.fragment_watch) {

    private var _binding: FragmentWatchBinding? = null

    @Inject
    lateinit var adapter: UpComingMoviesAdapter

    override val viewModel: WatchViewModel by viewModels()

    override fun getBindingVariable() = BR.viewModel

    override fun initUi() {
        _binding = bindings
        setUpRecyclerView()
        viewModel.fetchMovies()

        viewModel.fetchMoviesApiResponse.observe(viewLifecycleOwner, {
            when (it) {
                is State.Loading -> {
                    viewModel.isLoading.value = true
                }
                is State.Success -> {
                    viewModel.isLoading.value = false
                    it.wrapperData.movieModels.let { list ->
                        if (list.isNotEmpty()) {
                            adapter.addItems(list)
                        }
                    }
                }
                is State.Error -> {
                    viewModel.isLoading.value = false
                    requireContext().showShortToast("Error")
                }
            }
        })
    }

    private fun setUpRecyclerView() {
        val mItemOffsetDecoration = ItemOffsetDecoration(
            requireContext(),
            R.dimen.zero,
            R.dimen.zero,
            R.dimen.item_movies_margin_top,
            R.dimen.item_movies_margin_top
        )
        bindings.rvMovies.addItemDecoration(mItemOffsetDecoration)
        bindings.rvMovies.adapter = adapter

        adapter.setItemListener(object : OnItemClickListener {
            override fun onItemClick(model: MovieModel) {
                activity?.let {
                    it.launchActivity(
                        it, MovieDetailActivity::class.java,
                        bundle = Bundle().also {
                            it.putInt(CommonTags.MOVIE_ID, model.id)
                        }
                    )
                }
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}