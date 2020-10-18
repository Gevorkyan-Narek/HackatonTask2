package com.cyclone.hackatontask2.main

import moxy.MvpAppCompatFragment

open class BaseFragment(contentLayoutId: Int) : MvpAppCompatFragment(contentLayoutId) {

    lateinit var navigateTo: NavigateTo

    fun setNavigate(navigateTo: NavigateTo) {
        this.navigateTo = navigateTo
    }
}