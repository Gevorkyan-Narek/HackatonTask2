package com.cyclone.hackatontask2.collection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cyclone.hackatontask2.R
import kotlinx.android.synthetic.main.collection_main_fragment.*

class CollectionMainFragment : Fragment(R.layout.collection_main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startCollecting.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("collection_fragment")
                .replace(R.id.collection_fragment, ChooseTypeCollectionFragment()).commit()
        }
    }
}