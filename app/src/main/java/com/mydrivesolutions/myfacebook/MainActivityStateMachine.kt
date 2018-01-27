package com.mydrivesolutions.myfacebook

import com.mydrivesolutions.myfacebook.data.Person
import com.mydrivesolutions.myfacebook.data.TeamProvider
import com.mydrivesolutions.myfacebook.ui.main.MainActivityViewStatus

open class MainActivityStateMachine constructor(private var state: MainActivityCurrentState = MainActivityCurrentState.Initial):
        StateMachine {

    internal var person: Person = TeamProvider.ALL[0]
    private var numFailure: Int = 0
    private var numSuccess: Int = 0

    override fun enter(newStatus: MainActivityCurrentState): MainActivityViewStatus {
        state = newStatus
        return current()
    }

    override fun newPerson(person: Person): MainActivityViewStatus {
        this.person = person
        return enter(MainActivityCurrentState.NewQuiz)
    }

    override fun onResult(success: Boolean): MainActivityViewStatus {
        val newStatus = if (success) {
            numSuccess++
            MainActivityCurrentState.Success
        } else {
            numFailure++
            MainActivityCurrentState.Error
        }
        return enter(newStatus)
    }

    override fun current(): MainActivityViewStatus {
        return MainActivityViewStatus(
                person,
                numFailure,
                numSuccess,
                state.isSuccess,
                state.isError,
                state.isNewQuiz
        )
    }

}