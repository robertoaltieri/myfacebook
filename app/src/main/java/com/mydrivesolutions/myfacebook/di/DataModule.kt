package com.mydrivesolutions.myfacebook.di

import com.mydrivesolutions.myfacebook.MainActivityStateMachine
import com.mydrivesolutions.myfacebook.bl.Quiz
import com.mydrivesolutions.myfacebook.bl.QuizImpl
import com.mydrivesolutions.myfacebook.data.FacebookRepository
import com.mydrivesolutions.myfacebook.data.FacebookRepositoryImpl
import com.mydrivesolutions.myfacebook.ui.main.di.MainActivitySubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MainActivitySubComponent::class])
class DataModule {
    @Provides
    @Singleton
    fun provideFacebookRepository(stateMachine: MainActivityStateMachine): FacebookRepository {
        return FacebookRepositoryImpl(stateMachine)
    }

    @Provides
    @Singleton
    fun provideQuiz(facebook: FacebookRepository, stateMachine: MainActivityStateMachine): Quiz {
        return QuizImpl(facebook, stateMachine)
    }
}
