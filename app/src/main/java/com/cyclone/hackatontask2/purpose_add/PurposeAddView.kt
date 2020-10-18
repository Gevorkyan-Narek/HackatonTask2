package com.cyclone.hackatontask2.purpose_add

import com.cyclone.hackatontask2.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PurposeAddView : BaseView {

    fun isEnable(enable: Boolean)
}