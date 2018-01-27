package com.mydrivesolutions.myfacebook.ui.main

import com.mydrivesolutions.myfacebook.bl.Quiz
import com.mydrivesolutions.myfacebook.di.ActivityScope
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScope
class MainActivityPresenter @Inject constructor(
        private val view: MainActivityView,
        private val quiz: Quiz
) {
    fun createModel(): Observable<MainActivityViewStatus> {
        val newQuiz = quiz.newQuiz(false)
        val result = view.guessedIntention.switchMap { quiz.newTry(it) }
        val victory = view.victoryIntention.switchMap { quiz.newQuiz(true) }
        return Observable.merge(newQuiz, result, victory)
    }
}
