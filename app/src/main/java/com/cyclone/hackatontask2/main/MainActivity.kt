package com.cyclone.hackatontask2.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cyclone.hackatontask2.R
import com.cyclone.hackatontask2.collection.CollectionMainFragment
import com.cyclone.hackatontask2.purpose_add.PurposeCollectionAdditionFragment
import com.cyclone.hackatontask2.purpose_regular.purpose.PurposeCollectionFragment
import com.cyclone.hackatontask2.purpose_regular.regular.RegularCollectionFragment
import com.cyclone.hackatontask2.type.ChooseTypeCollectionFragment
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), NavigateTo {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toMain()
    }

    override fun toMain() {
        switch(CollectionMainFragment().apply { setNavigate(this@MainActivity) })
    }

    override fun toType() {
        switch(ChooseTypeCollectionFragment().apply { setNavigate(this@MainActivity) })
    }

    override fun toRegular() {
        switch(RegularCollectionFragment().apply { setNavigate(this@MainActivity) })
    }

    override fun toPurpose() {
        switch(PurposeCollectionFragment().apply { setNavigate(this@MainActivity) })
    }

    override fun toPurposeAdd() {
        switch(PurposeCollectionAdditionFragment().apply { setNavigate(this@MainActivity) })
    }

    override fun backFragment() {
        supportFragmentManager.popBackStack()
    }

    private fun switch(fragment: Fragment) {
        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.collection_fragment, fragment).commit()
    }
}