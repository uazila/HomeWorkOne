package com.example.lesson1homework

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TableLayout
import androidx.lifecycle.ViewModelProvider
import com.example.lesson1homework.databinding.ActivityMainBinding
import com.example.lesson1homework.ui.MainViewModel
import com.example.lesson1homework.ui.PagerAdapter
import com.example.lesson1homework.ui.firstFragment.FirstFragment
import com.example.lesson1homework.ui.secondFragment.SecondFragment
import com.example.lesson1homework.ui.thirdFragment.ThirdFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    private val fragmentList= listOf(FirstFragment(),SecondFragment(),ThirdFragment())
    private val fragmetTitles= listOf("Первый","Второй","Третий")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val animDrawable = binding.root.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(2000)
        animDrawable.setExitFadeDuration(4000)
        animDrawable.start()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter=PagerAdapter(this,fragmentList)

        binding.viewPager.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab: TabLayout.Tab, i: Int ->
            tab.text = fragmetTitles[i]
        }.attach()
    }

}