/**
 * Author: chenjin
 * Date: 2019-11-28 15:49
 * Description:
 */
package io.j99.app.template.ui.common.view

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment


abstract class AbstractBottomDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCanceledOnTouchOutside(true)
        val window: Window? = dialog.window
        window?.attributes = window?.attributes?.apply {
            gravity = Gravity.BOTTOM
            width = WindowManager.LayoutParams.MATCH_PARENT
        }
        return dialog
    }
}