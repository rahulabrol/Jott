package com.rahul.jott.global.base.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * @param context
 * @param text - text to copy to System Clipboard
 * @param label – User-visible label for the clip data.
 * @return true if copy is successful
 */
fun copyToClipborard(
    context: Context,
    text: String,
    label: String? = null
): Boolean {
    try {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText(label, text)
        clipboard.setPrimaryClip(clipData)
    } catch (e: Throwable) {
        return false
    }

    return true
}
