package com.cyclone.hackatontask2.main

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class ActivityPresenter : MvpPresenter<ActivityView>() {

    init {
        viewState.toMain()
    }

    fun toMainFragment() = viewState.toMain()
    fun toTypeFragment() = viewState.toType()
    fun toRegularFragment() = viewState.toRegular()
    fun toPurposeFragment() = viewState.toPurpose()
    fun toPurposeAddFragment() = viewState.toPurposeAdd()

    fun toBackFragment() = viewState.toBack()
}