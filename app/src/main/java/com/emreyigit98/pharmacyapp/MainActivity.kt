package com.emreyigit98.pharmacyapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.emreyigit98.pharmacyapp.presentation.navigation.PharmacyNavApp
import com.emreyigit98.pharmacyapp.presentation.ui.theme.PharmacyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PharmacyAppTheme {
                installSplashScreen()
                Surface(
                    modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.special_black)
                ) {
                    PharmacyNavApp(
                        clickable = {
                            try {
                                val uri = Uri.parse("tel:"+it.phone)
                                val intent = Intent(Intent.ACTION_DIAL,uri)
                                this.startActivity(intent)
                            }catch (exception : SecurityException) {
                                Toast.makeText(this,"${exception.message}",Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }
            }
        }
    }
}