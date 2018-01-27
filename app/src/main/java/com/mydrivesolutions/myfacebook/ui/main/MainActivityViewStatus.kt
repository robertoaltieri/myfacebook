package com.mydrivesolutions.myfacebook.ui.main

import com.mydrivesolutions.myfacebook.data.Person

data class MainActivityViewStatus constructor(val person: Person,
                                              val numFailure: Int = 0,
                                              val numSuccess: Int = 0,
                                              val isSuccess: Boolean = false,
                                              val isError: Boolean = false,
                                              val isNewQuiz: Boolean = true)
