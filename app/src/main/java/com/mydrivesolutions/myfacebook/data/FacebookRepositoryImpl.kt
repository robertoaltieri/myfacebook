package com.mydrivesolutions.myfacebook.data

import com.mydrivesolutions.myfacebook.MainActivityStateMachine
import com.mydrivesolutions.myfacebook.ui.main.MainActivityViewStatus
import io.reactivex.Observable
import javax.inject.Inject

class FacebookRepositoryImpl @Inject constructor(private val stateMachine: MainActivityStateMachine): FacebookRepository {
    private var counter : Int = 0
    override fun quiz(newQuiz: Boolean): Observable<MainActivityViewStatus> {
        return if (newQuiz) {
            val person = TeamProvider.ALL[++counter % TeamProvider.ALL.size]
            Observable.just(stateMachine.newPerson(person))
        } else {
            Observable.just(stateMachine.current())
        }
    }

    override fun check(name: String): Boolean {
        return stateMachine.person.name == name
    }
}
