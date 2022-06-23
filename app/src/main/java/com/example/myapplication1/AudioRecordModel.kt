package com.example.myapplication1

import java.util.*

data class AudioRecordModel(
    var id: Int = getAutoId(),
    var filename: String = "",
    var filePath: String = "",
    var timestamp: Int = 0,
    var duration: String = "",
    var ampsPath: String = ""
) {
    companion object{
        fun getAutoId(): Int{
            val random = Random()
            return random.nextInt(100)
        }
    }
}