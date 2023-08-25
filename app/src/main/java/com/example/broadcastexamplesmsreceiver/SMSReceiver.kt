package com.example.broadcastexamplesmsreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.telephony.SmsMessage
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SMSReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.provider.Telephony.SMS_RECEIVED") {
            val smsBundle = intent.extras
            if (smsBundle != null) {
                val pdus = smsBundle.get("pdus") as? Array<ByteArray>

                pdus?.forEach { pdu ->
                    val smsMessage = SmsMessage.createFromPdu(pdu)
                    val message = smsMessage.messageBody

                    // ViewModel'e mesajı güncellemek yerine, LiveData veya StateFlow kullanarak güncellemeyi düşünmelisiniz.
                    // ...
                }
            }
        }
    }
}