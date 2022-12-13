package com.leesunae.study_mvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import com.leesunae.bebehelper_mvp.view.base.BaseActivity
import com.leesunae.study_mvvm.R
import com.leesunae.study_mvvm.databinding.ActivityMainBinding
import com.leesunae.study_mvvm.viewModel.FruitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: FruitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        setClickEvent()
    }

    private fun setClickEvent() {
        binding.apply {
            tvRegistrationBtn.setOnClickListener {
                val fruitName = etInputFruitRegistration.text.toString()
                viewModel.registerFruit(fruitName)
            }
            tvSearchBtn.setOnClickListener {
                viewModel.searchFruit(etInputFruitSearch.text.toString())
            }
        }
    }

    private fun setupViewModel() {
        viewModel.apply {
            registeredFruit.observe(this@MainActivity) {
                binding.registrationResult = it
            }
            searchFruit.observe(this@MainActivity) {
                binding.searchResult = it
            }
        }
    }
}