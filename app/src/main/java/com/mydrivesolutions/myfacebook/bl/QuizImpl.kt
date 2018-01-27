package com.mydrivesolutions.myfacebook.bl

import com.mydrivesolutions.myfacebook.MainActivityStateMachine
import com.mydrivesolutions.myfacebook.data.FacebookRepository
import com.mydrivesolutions.myfacebook.ui.main.MainActivityViewStatus
import io.reactivex.Observable
import javax.inject.Inject

class QuizImpl @Inject constructor(
        private var facebook: FacebookRepository,
        private val stateMachine: MainActivityStateMachine
) : Quiz {
    override fun newQuiz(newQuiz: Boolean): Observable<out MainActivityViewStatus> {
        return facebook.quiz(newQuiz)
    }

    override fun newTry(name: String): Observable<out MainActivityViewStatus> {
        return Observable.just(stateMachine.onResult(facebook.check(name)))
    }

}
