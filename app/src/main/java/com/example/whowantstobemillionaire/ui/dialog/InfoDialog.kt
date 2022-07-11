package com.example.whowantstobemillionaire.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.whowantstobemillionaire.R

class InfoDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setTitle(getString(R.string.info_dialog_title))
            .setMessage(R.string.info_dialog_message)
            .setPositiveButton(R.string.info_dialog_button) {dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

    companion object {
        const val TAG = "InfoDialog"
    }
}