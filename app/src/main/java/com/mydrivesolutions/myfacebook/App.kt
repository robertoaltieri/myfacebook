package com.mydrivesolutions.myfacebook

import com.mydrivesolutions.myfacebook.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerAppComponent.builder().create(this)
    }
}
