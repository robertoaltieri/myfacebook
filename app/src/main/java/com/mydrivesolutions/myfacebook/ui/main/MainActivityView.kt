package com.mydrivesolutions.myfacebook.ui.main

import io.reactivex.Observable

interface MainActivityView {
    val guessedIntention: Observable<String>
    val victoryIntention: Observable<Any>
}