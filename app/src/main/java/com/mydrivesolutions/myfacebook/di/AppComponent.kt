package com.mydrivesolutions.myfacebook.di

import com.mydrivesolutions.myfacebook.App
import com.mydrivesolutions.myfacebook.ui.main.di.MainActivitySubComponent
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    DataModule::class,
    MainActivitySubComponent.ComponentBindsModule::class,
    MainActivitySubComponent.ComponentModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
