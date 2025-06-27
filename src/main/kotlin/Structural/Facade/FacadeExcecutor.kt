package org.example.Structural.Facade

import org.example.PatternExecutor

class FacadeExcecutor : PatternExecutor {
    override fun main() {
        val videoConverter = VideoConverterFacadeImpl()
        val convertedVideo = videoConverter.convertVideo(VideoFile("cat_video.mp4"), targetFormat = "ogg")

        println(convertedVideo)
    }
}