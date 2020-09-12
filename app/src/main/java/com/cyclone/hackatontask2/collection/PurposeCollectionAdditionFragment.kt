package com.cyclone.hackatontask2.collection

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.cyclone.hackatontask2.R
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.purpose_collection_additionaly_fragment.*
import rx.Observable

class PurposeCollectionAdditionFragment :
    Fragment(R.layout.purpose_collection_additionaly_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Observable.combineLatest(
            RxTextView.textChanges(inputDate),
            RxTextView.textChanges(inputAuthor)
        ) { t1, t2 ->
            startCollecting.isEnabled = t1.isNotEmpty() && t2.isNotEmpty()
        }.subscribe()

    }
}