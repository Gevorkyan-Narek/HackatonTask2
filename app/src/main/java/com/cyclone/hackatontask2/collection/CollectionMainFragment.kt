package com.cyclone.hackatontask2.collection

import android.os.Bundle
import android.view.View
import com.cyclone.hackatontask2.R
import com.cyclone.hackatontask2.main.BaseFragment
import kotlinx.android.synthetic.main.collection_main_fragment.*

class CollectionMainFragment : BaseFragment(R.layout.collection_main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startCollecting.setOnClickListener { navigateTo.toType() }
    }
}