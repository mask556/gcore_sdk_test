package com.example.gcore_sdk_test

import android.app.Application
import gcore.videocalls.meet.GCoreMeet

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        GCoreMeet.instance.init(this, null, false)
    }

}