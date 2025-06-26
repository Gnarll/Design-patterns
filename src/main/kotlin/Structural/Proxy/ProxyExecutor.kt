package org.example.Structural.Proxy

import org.example.PatternExecutor
import org.example.Structural.Proxy.YoutubeDownloadLib.ProxyService
import org.example.Structural.Proxy.YoutubeDownloadLib.YoutubeDownloadServiceImpl
import kotlin.system.measureTimeMillis

class ProxyExecutor : PatternExecutor {
    override fun main() {
        val downloadService = YoutubeDownloadServiceImpl()
        val proxyService = ProxyService(service = downloadService)
        val videoPlayer = VideoPlayer(downloadService = proxyService)

        val time = measureTimeMillis {
            val recentVideos = videoPlayer.showRecentVideos()
            repeat(10) {
                if (it % 2 == 0) {
                    videoPlayer.watchVideo(
                        recentVideos[0].id
                    )
                }

                if (it % 3 == 0) {
                    videoPlayer.watchVideo(
                        recentVideos[2].id
                    )
                }

                videoPlayer.watchVideo(
                    recentVideos[1].id
                )
            }
        }

        println()
        println("MEASURED TIME $time ms.")
    }
}