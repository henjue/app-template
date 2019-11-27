package io.j99.app.template.ui.main.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import io.j99.app.template.R
import io.j99.app.template.di.Injectable
import io.j99.app.template.ui.main.vm.HomePageViewModel
import javax.inject.Inject

class HomePageFragment : Fragment(), Injectable {

    companion object {
        fun newInstance() = HomePageFragment()
    }

    private lateinit var pageViewModel: HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    @Inject
    lateinit var mFactory: ViewModelProvider.Factory

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this, mFactory).get(HomePageViewModel::class.java)
    }

}
