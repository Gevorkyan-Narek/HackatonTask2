package com.cyclone.hackatontask2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.choose_type_collection_fragment.*
import kotlinx.android.synthetic.main.collection_main_fragment.*

class CollectionMainFragment : Fragment(R.layout.collection_main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startCollecting.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("collection_fragment")
                .replace(R.id.collection_fragment, ChooseTypeCollectionFragment()).commit()
        }
    }
}