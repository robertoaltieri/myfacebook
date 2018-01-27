package com.mydrivesolutions.myfacebook.data

import com.mydrivesolutions.myfacebook.ui.main.MainActivityViewStatus
import io.reactivex.Observable

interface FacebookRepository {
    fun check(name: String): Boolean
    fun quiz(newQuiz: Boolean): Observable<MainActivityViewStatus>
}