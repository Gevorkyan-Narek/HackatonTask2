package com.cyclone.hackatontask2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.choose_type_collection_fragment.*

class ChooseTypeCollectionFragment: Fragment(R.layout.choose_type_collection_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        backButton.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }
}