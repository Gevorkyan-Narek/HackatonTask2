package com.cyclone.hackatontask2.main

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ActivityView : MvpView {

    fun toMain()
    fun toType()
    fun toRegular()
    fun toPurpose()
    fun toPurposeAdd()

    fun toBack()
}