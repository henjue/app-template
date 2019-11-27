package io.j99.app.template.ext

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun Context.showToast(@StringRes esId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, esId, duration).show()
}