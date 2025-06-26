package org.example.Structural.Proxy

import org.example.Structural.Proxy.YoutubeDownloadLib.Video
import org.example.Structural.Proxy.YoutubeDownloadLib.YoutubeDownloadService

// client class for watching videos
class VideoPlayer(private val downloadService: YoutubeDownloadService) {
    fun showRecentVideos(): List<Video> {
        return downloadService.fetchVideosList()
    }

    fun watchVideo(id: Int) {
        val videoFile = downloadService.downloadVideo(id)

        if (videoFile == null) {
            println("No such a video")
            return
        }

        println("watching ${videoFile.name}. Details: ${videoFile.video}")
    }
}