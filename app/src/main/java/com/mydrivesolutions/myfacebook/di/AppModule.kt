package com.mydrivesolutions.myfacebook.di

import com.mydrivesolutions.myfacebook.MainActivityStateMachine
import com.mydrivesolutions.myfacebook.ui.main.di.MainActivitySubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MainActivitySubComponent::class])
class AppModule {

    @Provides
    @Singleton
    fun provideStateMachine(): MainActivityStateMachine {
        return MainActivityStateMachine()
    }
}
