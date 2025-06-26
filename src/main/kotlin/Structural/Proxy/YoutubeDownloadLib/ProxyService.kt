package org.example.Structural.Proxy.YoutubeDownloadLib


// intermediate service for caching data with expensive retrieving
// clear cache logic is omitted for simplicity
class ProxyService(private val service: YoutubeDownloadService = YoutubeDownloadServiceImpl()) :
    YoutubeDownloadService {
    private var cachedVideosList: MutableList<Video> = mutableListOf()
    private var cachedVideoFiles: MutableMap<Int, VideoFile> = mutableMapOf()

    override fun fetchVideosList(): List<Video> {
        if (cachedVideosList.isEmpty()) {
            cachedVideosList.addAll(service.fetchVideosList())
        }
        return cachedVideosList
    }

    override fun downloadVideo(id: Int): VideoFile? = cachedVideoFiles[id] ?: service.downloadVideo(id)?.also {
        cachedVideoFiles[id] = it
    }
}