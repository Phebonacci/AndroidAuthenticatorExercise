package com.phebetries.authenticator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.phebetries.authenticator.util.SessionStore
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    supportActionBar?.hide()
    loginButton.onClick {

      val email = emailEdit.text.toString()
      val password = passwordEdit.text.toString()

      validate(email, password)
    }
  }

  private fun validate(email: String, password: String) {

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

      alert(R.string.login_email_invalid, R.string.error_title) {
        okButton { return@okButton }
      }.show()

      return
    }

    if (email.isEmpty() || password.isEmpty()) {

      alert(R.string.login_form_incomplete, R.string.error_title) {
        okButton {
          return@okButton
        }
      }.show()

      return
    }

    if (email.equals("frankannstein@mail.com") && password.equals("mojako123")) {

      startActivity<MainActivity>()
      val store = SessionStore()
      store.saveEmail(email, this)
      finish()
    } else {
      alert(R.string.login_invalid_credentials, R.string.error_title) {
        okButton { return@okButton }
      }.show()
    }
  }
}
