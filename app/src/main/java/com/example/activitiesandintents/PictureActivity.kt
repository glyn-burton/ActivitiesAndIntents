package com.example.activitiesandintents

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.webkit.PermissionRequest
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_picture.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast



class PictureActivity : AppCompatActivity() {

    val TAG_PICTURE_ACTIVITY = "TAG PICTURE"
    val CAMERA_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val permission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CAMERA
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // Requesting the permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_CODE
            )

        }
    }


    // This function is called when the user accepts or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when the user is prompt for permission.

override fun onRequestPermissionsResult(requestCode: Int,
                                        permissions: Array<String>, grantResults: IntArray) {
    when (requestCode) {
        CAMERA_PERMISSION_CODE -> {

            if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                Log.d(TAG_PICTURE_ACTIVITY, "Permission has been denied by user")
            } else {
                Log.i(TAG_PICTURE_ACTIVITY, "Permission has been granted by user")
            }
        }
    }
}



override fun onStart(){
        super.onStart()
        Log.d(TAG_PICTURE_ACTIVITY,"onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG_PICTURE_ACTIVITY,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG_PICTURE_ACTIVITY,"onPause")
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG_PICTURE_ACTIVITY,"onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG_PICTURE_ACTIVITY,"onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG_PICTURE_ACTIVITY,"onDestroy")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                348 -> {

                    val extras = data?.getExtras()
                    val camImage = extras?.get("data") as Bitmap
                    ivCamResult.setImageBitmap(camImage)

                }
            }
        }
    }

    fun pictureCapture(view: View) {

        val takePic = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePic, 348)
    }


}
