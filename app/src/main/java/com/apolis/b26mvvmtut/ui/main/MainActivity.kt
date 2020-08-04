package com.apolis.b26mvvmtut.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.apolis.b26mvvmtut.adapters.AdapterRepo
import com.hb.b26mvvmtut.R
import com.hb.b26mvvmtut.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val mAdapter: AdapterRepo = AdapterRepo(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        initList()
        observerData()
    }

    private fun initList(){
        binding.recyclerView.apply {
            adapter = mAdapter
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.onButtonClicked()
        }
    }

    //This method is used to observer data from ViewModel
    private fun observerData() {
        viewModel.getGithubRepositoryObserver().observe(this, Observer {
            binding.swipeRefreshLayout.isRefreshing = false
            if (it != null) {
                mAdapter.setData(it)
            }
        })
    }
}