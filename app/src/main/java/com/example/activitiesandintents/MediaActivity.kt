package com.example.activitiesandintents

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_media.*

class MediaActivity : AppCompatActivity() {

    private var video: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        VideoPlayback.setVideoURI (Uri.parse("android.resource://" + packageName + "/" + R.raw.jpnvid))
        VideoPlayback.start()
    }
}
