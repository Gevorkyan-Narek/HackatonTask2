package com.cyclone.hackatontask2.purpose_regular

import android.net.Uri
import com.cyclone.hackatontask2.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PurposeRegularView: BaseView {

    fun loadCover(path: Uri?)
    fun isEnable(enable: Boolean)
}