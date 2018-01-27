package com.mydrivesolutions.myfacebook.ui.main

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.jakewharton.rxbinding2.view.RxView
import com.mydrivesolutions.myfacebook.R
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainActivityView {
    @Inject
    lateinit var presenter: MainActivityPresenter
    @BindView(R.id.name)
    lateinit var enteredName: EditText
    @BindView(R.id.button_ok)
    lateinit var okButton: TextView
    @BindView(R.id.victory)
    lateinit var victoryButton: ImageView
    @BindView(R.id.num_failure)
    lateinit var numFailure: TextView
    @BindView(R.id.num_success)
    lateinit var numSuccess: TextView
    @BindView(R.id.face_image)
    lateinit var image: ImageView

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    override fun onResume() {
        super.onResume()
        val model = presenter.createModel()
        compositeDisposable.add(model.subscribe { showStatus(it) })
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }

    private fun showStatus(status: MainActivityViewStatus) {
        victoryButton.visibility = if (status.isSuccess) {
            Picasso.with(this).load(status.person.happyUrl).into(victoryButton)
            image.visibility = View.GONE
            okButton.visibility = View.GONE
            enteredName.setText(status.person.name)
            enteredName.inputType = InputType.TYPE_NULL
            View.VISIBLE
        } else {
            image.visibility = View.VISIBLE
            okButton.visibility = View.VISIBLE
            enteredName.inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            View.GONE
        }
        if (status.isNewQuiz) {
            enteredName.text.clear()
        }
        numFailure.text = status.numFailure.toString()
        numSuccess.text = status.numSuccess.toString()
        Picasso.with(this).load(status.person.imageUrl).into(image)
    }

    // intent function for OK button
    override val guessedIntention: Observable<String>
        get() = RxView.clicks(okButton).map { enteredName.text.toString() }

    // intent function for victory button
    override val victoryIntention: Observable<Any>
        get() = RxView.clicks(victoryButton)
}
