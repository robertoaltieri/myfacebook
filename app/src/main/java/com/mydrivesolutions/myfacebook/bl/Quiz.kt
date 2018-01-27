package com.mydrivesolutions.myfacebook.bl

import com.mydrivesolutions.myfacebook.ui.main.MainActivityViewStatus
import io.reactivex.Observable

interface Quiz {
    fun newTry(name: String): Observable<out MainActivityViewStatus>
    fun newQuiz(newQuiz: Boolean): Observable<out MainActivityViewStatus>
}
