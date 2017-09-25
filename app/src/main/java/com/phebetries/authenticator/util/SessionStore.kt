/**
 * Authenticator
 *
 * Created by iomusashi on 9/21/17.
 * Copyright (c) 2017 iomusashi. All rights reserved.
 */

package com.phebetries.authenticator.util

import android.content.Context
import android.content.SharedPreferences

class SessionStore {

  val KEY_USER_EMAIL = "email"

  fun saveEmail(email: String, context: Context) {

    val editor = context
        .getSharedPreferences(KEY_USER_EMAIL,
                              Context.MODE_PRIVATE)
        .edit()
    editor.putString(KEY_USER_EMAIL, email)
    editor.apply()
  }

  fun restoreEmail(context: Context) : String {

    val prefs = context.getSharedPreferences(KEY_USER_EMAIL,
                                             Context.MODE_PRIVATE)
    return prefs.getString(KEY_USER_EMAIL, "")
  }

  fun clearEmail(context: Context) {

    val editor = context
        .getSharedPreferences(KEY_USER_EMAIL,
            Context.MODE_PRIVATE)
        .edit()
    editor.clear()
    editor.apply()
  }
}
