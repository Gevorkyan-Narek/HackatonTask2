package com.cyclone.hackatontask2.collection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cyclone.hackatontask2.R
import kotlinx.android.synthetic.main.choose_type_collection_fragment.*

class ChooseTypeCollectionFragment: Fragment(R.layout.choose_type_collection_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        backButton.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        purposeCollection.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("chooseTypeCollection")
                .replace(R.id.collection_fragment, PurposeCollectionFragment()).commit()
        }

        regularCollection.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("chooseTypeCollection")
                .replace(R.id.collection_fragment, RegularCollectionFragment()).commit()
        }
    }
}