package com.mydrivesolutions.myfacebook.ui.main.di

import android.app.Activity
import com.mydrivesolutions.myfacebook.di.ActivityScope
import com.mydrivesolutions.myfacebook.ui.main.MainActivity
import com.mydrivesolutions.myfacebook.ui.main.MainActivityView
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@ActivityScope
@Subcomponent(modules = [
    MainActivitySubComponent.ComponentBindsModule::class,
    MainActivitySubComponent.ComponentModule::class
])
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

    @Module
    abstract class ComponentBindsModule {
        @Binds
        @IntoMap
        @ActivityKey(MainActivity::class)
        internal abstract fun bind(builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
    }

    @Module
    class ComponentModule {
        @ActivityScope
        @Provides
        fun provideMainActivityView(activity: MainActivity): MainActivityView {
            return activity
        }
    }

}