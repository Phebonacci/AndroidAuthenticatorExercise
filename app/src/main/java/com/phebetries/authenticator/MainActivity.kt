package com.phebetries.authenticator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.phebetries.authenticator.model.User
import com.phebetries.authenticator.util.SessionStore
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.startActivity
import java.util.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      setSupportActionBar(toolbar)

      val user = User(
            "Frank Ann Stein",
            "Female",
            "01 Nov 1991",
            "Davao, Philippines")

      userNameText.text = user.name
      userGenderText.text = user.gender
      userBirthDateText.text = user.birthDate
      userLocationText.text = user.location
      collapsing.title = user.name
  }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.logout -> {
                alert (R.string.logout_confirm_message, R.string.logout_confirm_title) {
                    okButton {
                        val session = SessionStore()
                        session.clearEmail(this@MainActivity)
                        startActivity<LoginActivity>()
                        finish()
                    }
                }.show()
            }
        }
        return true
    }
}
