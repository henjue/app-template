/**
 * Author: chenjin
 * Date: 2019/7/8 10:51
 * Description:
 */
package io.j99.app.template.ui.common.view

import android.app.Dialog
import android.os.Bundle
import androidx.annotation.MainThread
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

interface DialogClickListener {
    @MainThread
    fun onClickOk()

    @MainThread
    fun onClickCancel()
}

class AppDialog : DialogFragment() {
    var clickListener: DialogClickListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val args = ConfirmDialogArgs.fromBundle(arguments ?: Bundle())
        return AlertDialog.Builder(requireContext())
            .setTitle(args.title)
            .setMessage(args.message)
            .setNegativeButton(
                args.okText
            ) { dialog, which -> clickListener?.onClickOk() }
            .setNeutralButton(
                args.cancelText
            ) { dialog, which -> clickListener?.onClickCancel() }
            .create()
    }

    companion object {
        @JvmStatic
        fun show(
            fm: FragmentManager,
            title: CharSequence? = null,
            message: CharSequence? = null,
            okText: CharSequence? = "确认",
            cancelText: CharSequence? = "取消",
            clickListener: DialogClickListener? = null
        ): AppDialog {
            val args = Bundle()
            args.putCharSequence("title", title)
            args.putCharSequence("message", message)
            args.putCharSequence("okText", okText)
            args.putCharSequence("cancelText", cancelText)
            val dialog = AppDialog()
            dialog.clickListener = clickListener
            dialog.arguments = args
            dialog.show(fm, "app_dialog")
            return dialog
        }

        fun hide(fm: FragmentManager) {
            fm.findFragmentByTag("app_dialog")?.let {
                if (it is AppDialog) {
                    it.dismissAllowingStateLoss()
                }
            }
        }
    }

    class ConfirmDialogArgs(
        val title: CharSequence? = null,
        val message: CharSequence? = null,
        val okText: CharSequence? = "确认",
        val cancelText: CharSequence? = "取消"
    ) {
        companion object {

            @JvmStatic
            fun fromBundle(args: Bundle): ConfirmDialogArgs {
                val title = args.getCharSequence("title")
                val message = args.getCharSequence("message")
                val okText = args.getCharSequence("okText")
                val cancelText = args.getCharSequence("cancelText")
                return ConfirmDialogArgs(
                    title,
                    message,
                    okText,
                    cancelText
                )
            }
        }
    }
}