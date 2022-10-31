package com.leesunae.study_mvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import com.leesunae.bebehelper_mvp.view.base.BaseActivity
import com.leesunae.study_mvvm.R
import com.leesunae.study_mvvm.databinding.ActivityMainBinding
import com.leesunae.study_mvvm.viewModel.FruitViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: FruitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        setClickEvent()
    }

    private fun setClickEvent() {
        binding.apply {
            tvBtn.setOnClickListener {
                viewModel.setFruit(etInput.text.toString())
            }
        }
    }

    private fun setupViewModel() {
        viewModel.fruit.observe(this) {
            binding.inputFruit = it
        }
    }
}