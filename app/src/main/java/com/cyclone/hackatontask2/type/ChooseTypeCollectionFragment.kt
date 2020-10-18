package com.cyclone.hackatontask2.type

import android.os.Bundle
import android.view.View
import com.cyclone.hackatontask2.R
import com.cyclone.hackatontask2.main.BaseFragment
import kotlinx.android.synthetic.main.choose_type_collection_fragment.*

class ChooseTypeCollectionFragment: BaseFragment(R.layout.choose_type_collection_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        backButton.setOnClickListener { navigateTo.backFragment() }

        purposeCollection.setOnClickListener { navigateTo.toPurpose() }

        regularCollection.setOnClickListener { navigateTo.toRegular() }
    }
}