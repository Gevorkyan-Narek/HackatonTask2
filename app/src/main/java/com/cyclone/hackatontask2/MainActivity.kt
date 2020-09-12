package com.cyclone.hackatontask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cyclone.hackatontask2.collection.CollectionMainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.collection_fragment, CollectionMainFragment()).commit()
    }
}