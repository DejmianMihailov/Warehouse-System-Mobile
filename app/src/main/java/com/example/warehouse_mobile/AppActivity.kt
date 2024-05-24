package com.example.warehouse_mobile

import android.app.Application
import com.example.warehouse_mobile.data.AppContainer
import com.example.warehouse_mobile.data.DefaultAppContainer


class AppActivity : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
