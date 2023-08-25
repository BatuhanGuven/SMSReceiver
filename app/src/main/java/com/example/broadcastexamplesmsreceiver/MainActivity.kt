package com.example.broadcastexamplesmsreceiver

import SMSReceiverApp
import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.broadcastexamplesmsreceiver.ui.theme.BroadCastExampleSmsReceiverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val permissionLauncher = this.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            // İzin işlemleri
        }
        permissionLauncher.launch(Manifest.permission.READ_SMS)
        permissionLauncher.launch(Manifest.permission.RECEIVE_SMS)

        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        setContent {
            SMSReceiverApp(viewModel)
        }
    }
}