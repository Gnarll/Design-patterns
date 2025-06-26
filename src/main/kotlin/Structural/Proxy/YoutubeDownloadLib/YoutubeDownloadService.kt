package org.example.Structural.Proxy.YoutubeDownloadLib

private val SERVER_VIDEOS: List<Video> = listOf(
    Video(id = 1_000_000, title = "How to become a millionare?", duration = 50.0, likes = 1),
    Video(id = 69, title = "Maddyson quits drinking firmly and clearly", duration = 20.0, likes = Int.MAX_VALUE),
    Video(id = 42, title = "Python algorithms in one 5 minutes", duration = 9.5, likes = 12),
    Video(id = -1, title = "Did you know, that in AMEEEEEEEERICA...", duration = 9.5, likes = 120_000),
    Video(id = 666, title = "How to create a folder on Windows OS", duration = Double.MAX_VALUE, likes = 500_000_000),
)

// interface we exactly need for the Proxy realization
interface YoutubeDownloadService {
    fun fetchVideosList(): List<Video>
    fun downloadVideo(id: Int): VideoFile?
}

// 3rd party lib consuming many resources downloading videos
class YoutubeDownloadServiceImpl : YoutubeDownloadService {
    override fun fetchVideosList(): List<Video> {
        println("fetching recent videos")
        Thread.sleep(50)
        return SERVER_VIDEOS
    }

    override fun downloadVideo(id: Int): VideoFile? {
        println("downloading video with id: $id")
        Thread.sleep(200)

        val video: Video? = SERVER_VIDEOS.find { id == it.id }

        if (video == null) return null
        return VideoFile(video = video, name = video.title)
    }
}