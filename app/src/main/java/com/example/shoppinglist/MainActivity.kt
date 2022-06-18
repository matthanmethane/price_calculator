package com.example.shoppinglist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.shoppinglist.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
//        binding.bottomNavigation.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.page_1->{
//                    var fragment = supportFragmentManager.findFragmentByTag("1")
//                    supportFragmentManager.commit {
//                        setReorderingAllowed(true)
//                        if(fragment==null) fragment = FinalPriceFragment()
//                        replace(R.id.fragmentFinalPrice, fragment!!,"1")
//                    }
//                    true
//                }
//                R.id.page_2->{
//                    supportFragmentManager.commit {
//                        var fragment = supportFragmentManager.findFragmentByTag("2")
//                        setReorderingAllowed(true)
//                        if(fragment==null) fragment = DutchPayFragment()
//                        attach(fragment!!)
//                        replace(R.id.fragmentFinalPrice,fragment!!,"2")
//                    }
//                    true
//                }
//                else->false
//            }
//        }
//        binding.bottomNavigation.setOnItemReselectedListener { false }

    }




}