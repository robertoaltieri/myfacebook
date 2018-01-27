package com.mydrivesolutions.myfacebook

import com.mydrivesolutions.myfacebook.data.Person
import com.mydrivesolutions.myfacebook.ui.main.MainActivityViewStatus

interface StateMachine {
    fun newPerson(person: Person): MainActivityViewStatus
    fun onResult(success: Boolean): MainActivityViewStatus
    fun current(): MainActivityViewStatus
    fun enter(newStatus: MainActivityCurrentState): MainActivityViewStatus
}