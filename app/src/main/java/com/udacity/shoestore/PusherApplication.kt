package com.udacity.shoestore

import android.app.Application
import timber.log.Timber

class PusherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //set up timer in ShoeStore Application
        Timber.plant(Timber.DebugTree())
    }
}