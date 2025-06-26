package org.example.Structural.Proxy.YoutubeDownloadLib

data class Video(val title: String, val duration: Double, val likes: Int, val id: Int)

class VideoFile(val name: String, val video: Video)