package org.fossify.phone.dialogs

import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.fossify.commons.activities.BaseSimpleActivity
import org.fossify.commons.extensions.formatPhoneNumber
import org.fossify.commons.extensions.getAlertDialogBuilder
import org.fossify.commons.extensions.setupDialogStuff
import org.fossify.phone.R
import org.fossify.phone.extensions.config

class CallConfirmationDialog(
    val activity: BaseSimpleActivity,
    callee: String,
    val callback: () -> Unit
) {
    init {
        val callLabel = activity.getString(R.string.call_button)
        val displayCallee = if (activity.config.formatPhoneNumbers) callee.formatPhoneNumber() else callee
        val message = activity.getString(R.string.call_confirmation_message, displayCallee)
        val padding = (24 * activity.resources.displayMetrics.density).toInt()
        val messageView = TextView(activity).apply {
            text = message
            setPadding(padding, padding, padding, padding)
        }
        activity.getAlertDialogBuilder()
            .setView(messageView)
            .setPositiveButton(callLabel) { _, _ -> callback() }
            .setNegativeButton(R.string.cancel, null)
            .apply {
                activity.setupDialogStuff(messageView, this) { alertDialog ->
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).contentDescription = callLabel
                }
            }
    }
}
