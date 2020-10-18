package com.cyclone.hackatontask2.purpose_add

import android.os.Bundle
import android.view.View
import com.cyclone.hackatontask2.R
import com.cyclone.hackatontask2.main.BaseFragment
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.purpose_collection_additionaly_fragment.*
import moxy.presenter.InjectPresenter
import rx.Observable

class PurposeCollectionAdditionFragment :
    BaseFragment(R.layout.purpose_collection_additionaly_fragment), PurposeAddView {

    @InjectPresenter
    lateinit var presenter: PurposeAddPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        backButton.setOnClickListener { navigateTo.backFragment() }

        Observable.combineLatest(
            RxTextView.textChanges(inputDate),
            RxTextView.textChanges(inputAuthor)
        ) { t1, t2 ->
            presenter.isEnableButton(t1.isNotEmpty() && t2.isNotEmpty())
        }.subscribe()

    }

    override fun isEnable(enable: Boolean) { startCollecting.isEnabled = enable }
}