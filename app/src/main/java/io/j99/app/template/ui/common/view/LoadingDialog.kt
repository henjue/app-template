package io.j99.app.template.ui.common.view

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class LoadingDialog private constructor() : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = ProgressDialog(requireContext())
        dialog.setMessage(arguments?.getString("message"))
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    companion object {
        fun newInstence(message: String? = "请稍等"): LoadingDialog {
            return LoadingDialog().apply {
                arguments = Bundle().apply { putString("message", message) }
            }
        }
    }

}