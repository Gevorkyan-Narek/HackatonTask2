package com.cyclone.hackatontask2.type

import android.os.Bundle
import android.view.View
import com.cyclone.hackatontask2.R
import com.cyclone.hackatontask2.main.MainActivity
import kotlinx.android.synthetic.main.choose_type_collection_fragment.*
import moxy.MvpAppCompatFragment

class ChooseTypeCollectionFragment: MvpAppCompatFragment(R.layout.choose_type_collection_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        backButton.setOnClickListener { (activity as MainActivity).presenter.toBackFragment() }

        purposeCollection.setOnClickListener { (activity as MainActivity).presenter.toPurposeFragment() }

        regularCollection.setOnClickListener { (activity as MainActivity).presenter.toRegularFragment() }
    }
}