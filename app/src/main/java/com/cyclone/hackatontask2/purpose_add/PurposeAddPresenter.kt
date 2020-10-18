package com.cyclone.hackatontask2.purpose_add

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class PurposeAddPresenter: MvpPresenter<PurposeAddView>() {

    fun isEnableButton(enable: Boolean) = viewState.isEnable(enable)
}