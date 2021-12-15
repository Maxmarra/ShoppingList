package com.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    //проверка удаления элемента
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            //проверка создания списка
            Log.d("MainActivityTest", it.toString())
            //проверка удаления элемента
            //проверка редактирования (не делать вместе!!!)
            if(count == 0) {
                count++
                val item = it[0]
                //viewModel.deleteShopItem(item)
                viewModel.changeEnableState(item)
            }
        }

    }
}