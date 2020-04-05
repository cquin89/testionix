package com.losingtimeapps.testionix.domain.usecase

import com.losingtimeapps.testionix.domain.boundary.BaseScheduler

open class UseCase(private val baseScheduler: BaseScheduler) {

    fun uiInvoke() = baseScheduler.ui()

    fun computationInvoke() = baseScheduler.computation()

    fun ioInvoke() = baseScheduler.io()
}