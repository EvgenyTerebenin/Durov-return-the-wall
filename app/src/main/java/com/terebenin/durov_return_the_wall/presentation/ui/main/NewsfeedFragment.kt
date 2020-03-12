package com.terebenin.durov_return_the_wall.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.domain.newsfeed.NewsfeedInteractor
import com.terebenin.durov_return_the_wall.mvvm.NewsfeedViewModel
import com.terebenin.durov_return_the_wall.presentation.mvvm.main.NewsfeedVMFactory

class NewsfeedFragment : Fragment() {

    companion object {
        fun newInstance() =
            NewsfeedFragment()
    }

    private lateinit var viewModel: NewsfeedViewModel
    private lateinit var interactor: NewsfeedInteractor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            NewsfeedVMFactory(interactor)
        ).get(NewsfeedViewModel::class.java)
    }
}
