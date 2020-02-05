package com.example.activitiesandintents

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val WEB_PERMISSION_CODE = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {

        when(view.id){

            R.id.btnPictureActivity -> {

                val intent = Intent(this,PictureActivity::class.java)
                startActivity(intent)
            }
            R.id.btnEMIActivity -> {

                val intent = Intent(this,EMIActivity::class.java)
                startActivity(intent)

            }
            R.id.btnPersonActivity -> {
                val intent = Intent(this,PersonActivity::class.java)
                startActivityForResult(intent, 348)

            }
            R.id.btnWebActivity -> {
                val permission = ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.INTERNET
                )

                if (permission != PackageManager.PERMISSION_GRANTED) {
                    // Requesting the permission
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.INTERNET),
                        WEB_PERMISSION_CODE
                    )

                }
                else{val intent = Intent(this,WebVeiwActivity::class.java)
                    startActivity(intent)}


            }
            R.id.btnMediaActivity -> {

                val intent = Intent(this,MediaActivity::class.java)
                startActivity(intent)


            }



        }






    }
}
