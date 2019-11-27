package io.j99.app.template.ext

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun android.app.Fragment.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity, msg, duration).show()
}

fun android.app.Fragment.showToast(@StringRes esId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity, esId, duration).show()
}

fun Fragment.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), msg, duration).show()
}

fun Fragment.showToast(@StringRes esId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), esId, duration).show()
}