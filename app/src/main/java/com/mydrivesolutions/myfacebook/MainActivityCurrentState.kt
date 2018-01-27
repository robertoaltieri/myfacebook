package com.mydrivesolutions.myfacebook

interface MainActivityCurrentState {
    var isError: Boolean
    var isSuccess: Boolean
    var isNewQuiz: Boolean

    object Initial: MainActivityCurrentState {
        override var isError: Boolean = false
        override var isSuccess: Boolean = false
        override var isNewQuiz: Boolean = true
    }

    object Success: MainActivityCurrentState {
        override var isSuccess: Boolean = true
        override var isError: Boolean = false
        override var isNewQuiz: Boolean = false
    }

    object Error: MainActivityCurrentState {
        override var isSuccess: Boolean = false
        override var isError: Boolean = true
        override var isNewQuiz: Boolean = false
    }

    object NewQuiz : MainActivityCurrentState {
        override var isSuccess: Boolean = false
        override var isError: Boolean = false
        override var isNewQuiz: Boolean = true
    }
}