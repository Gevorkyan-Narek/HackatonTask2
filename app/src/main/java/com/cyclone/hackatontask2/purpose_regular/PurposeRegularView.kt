package com.cyclone.hackatontask2.purpose_regular

import android.net.Uri
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PurposeRegularView: MvpView {

    fun loadCover(path: Uri?)
    fun isEnable(enable: Boolean)
}