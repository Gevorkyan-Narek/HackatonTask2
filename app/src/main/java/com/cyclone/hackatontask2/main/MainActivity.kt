package com.cyclone.hackatontask2.main

import androidx.fragment.app.Fragment
import com.cyclone.hackatontask2.R
import com.cyclone.hackatontask2.collection.CollectionMainFragment
import com.cyclone.hackatontask2.purpose_add.PurposeCollectionAdditionFragment
import com.cyclone.hackatontask2.purpose_regular.purpose.PurposeCollectionFragment
import com.cyclone.hackatontask2.purpose_regular.regular.RegularCollectionFragment
import com.cyclone.hackatontask2.type.ChooseTypeCollectionFragment
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), ActivityView {

    @InjectPresenter
    lateinit var presenter: ActivityPresenter

    override fun toMain() {
        switchFragment(CollectionMainFragment())
    }

    override fun toType() {
        switchFragment(ChooseTypeCollectionFragment())
    }

    override fun toRegular() {
        switchFragment(RegularCollectionFragment())
    }

    override fun toPurpose() {
        switchFragment(PurposeCollectionFragment())
    }

    override fun toPurposeAdd() {
        switchFragment(PurposeCollectionAdditionFragment())
    }

    override fun toBack() {
        supportFragmentManager.popBackStack()
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.collection_fragment, fragment).commit()
    }
}