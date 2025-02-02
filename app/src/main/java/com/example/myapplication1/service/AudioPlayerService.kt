package com.example.myapplication1.service

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.support.v4.media.session.MediaSessionCompat
import androidx.core.app.NotificationCompat
import com.example.myapplication1.utils.ApplicationClass
import com.example.myapplication1.view.AudioPlayerActivity
import com.example.myapplication1.R

class AudioPlayerService : Service() {
    private var myBinder = MyBinder()
    var mediaPlayer: MediaPlayer? = null
    private lateinit var mediaSession: MediaSessionCompat

    override fun onBind(intent: Intent?): IBinder? {
        mediaSession = MediaSessionCompat(baseContext, "My Audio")
        return myBinder
    }

    inner class MyBinder: Binder(){
        fun currentService(): AudioPlayerService {
            return this@AudioPlayerService
        }
    }

    fun showNotification(btnPlayPause: Int){

        val playIntent = Intent(baseContext, AudioPlayerNotificationReceiver::class.java).setAction(
            ApplicationClass.PLAY
        )
        val playPendingIntent = if (Build.VERSION.SDK_INT < 31){
            PendingIntent.getBroadcast(baseContext, 0, playIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        } else {
            PendingIntent.getBroadcast(baseContext, 0, playIntent, PendingIntent.FLAG_MUTABLE)
        }

        val exitIntent = Intent(baseContext, AudioPlayerNotificationReceiver::class.java).setAction(
            ApplicationClass.EXIT
        )
        val exitPendingIntent = if (Build.VERSION.SDK_INT < 31){
            PendingIntent.getBroadcast(baseContext, 0, exitIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        } else {
            PendingIntent.getBroadcast(baseContext, 0, exitIntent, PendingIntent.FLAG_MUTABLE)
        }

        val notification = NotificationCompat.Builder(baseContext, ApplicationClass.CHANNEL_ID)
            .setContentTitle("Audio record playback")
            .setContentText(AudioPlayerActivity.filename)
            .setSmallIcon(R.drawable.ic_audiotrack)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_largeiconservice))
            .setStyle(androidx.media.app.NotificationCompat.MediaStyle())
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setSilent(true)
            .addAction(btnPlayPause, "Play", playPendingIntent)
            .addAction(R.drawable.ic_deletebig, "Exit", exitPendingIntent)
            .build()


        startForeground(13, notification)
    }

}