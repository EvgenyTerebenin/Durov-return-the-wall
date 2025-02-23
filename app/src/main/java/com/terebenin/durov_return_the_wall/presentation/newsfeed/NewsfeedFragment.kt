package com.terebenin.durov_return_the_wall.presentation.newsfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.databinding.MainFragmentBinding

class NewsfeedFragment : Fragment() {

    companion object {
        fun newInstance() =
            NewsfeedFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private lateinit var newsfeedAdapter: NewsfeedAdapter
    private val viewModel: NewsfeedViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@NewsfeedFragment
            vm = viewModel
            executePendingBindings()
        }
        initAdapter(viewModel)
        observeViewModelChanges(binding)
    }

    private fun observeViewModelChanges(binding: MainFragmentBinding) {
        binding.vm?.newsfeedResponse?.observe(viewLifecycleOwner, Observer {
            newsfeedAdapter.submitList(it.items)
        })

        binding.vm?.itemClickEvent?.observe(viewLifecycleOwner, Observer {
            //TODO
            Toast.makeText(context, "клик на пост с ID $it", Toast.LENGTH_SHORT).show()
        })
    }

    private fun initAdapter(viewModel: NewsfeedViewModel) {
        newsfeedAdapter =
            NewsfeedAdapter(
                viewModel
            )
        binding.recyclerViewNewsfeed.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsfeedAdapter
        }
    }

}
