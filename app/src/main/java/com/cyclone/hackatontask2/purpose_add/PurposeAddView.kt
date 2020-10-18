package com.cyclone.hackatontask2.purpose_add

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PurposeAddView: MvpView {

    fun isEnable(enable: Boolean)
}