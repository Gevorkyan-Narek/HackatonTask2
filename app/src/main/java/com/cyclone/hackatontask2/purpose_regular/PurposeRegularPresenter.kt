package com.cyclone.hackatontask2.purpose_regular

import android.net.Uri
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class PurposeRegularPresenter : MvpPresenter<PurposeRegularView>() {

    fun loadCover(path: Uri?) = viewState.loadCover(path)
    fun switchButton(enable: Boolean) = viewState.isEnable(enable)
}