package com.leesunae.study_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leesunae.bebehelper_mvp.view.base.BaseActivity
import com.leesunae.study_mvvm.R
import com.leesunae.study_mvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}