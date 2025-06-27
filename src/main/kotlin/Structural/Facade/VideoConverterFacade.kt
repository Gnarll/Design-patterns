package org.example.Structural.Facade

interface VideoConverterFacade {
    fun convertVideo(videofile: VideoFile, targetFormat: String): ByteArray
}

class VideoConverterFacadeImpl : VideoConverterFacade {
    override fun convertVideo(videofile: VideoFile, targetFormat: String): ByteArray {
        val sourceCodec = CodecFactory.extract(videofile)

        val buffer = BitrateReader.read(videofile.getFilename(), sourceCodec)

        val destinationCodec = when (targetFormat) {
            "ogg" -> OggCompressionCodec()
            "mp4" -> MPEG4CompressionCodec()
            else -> throw IllegalArgumentException("Unsupported format: $targetFormat")
        }

        val convertedBuffer = BitrateReader.convert(buffer, destinationCodec)

        val fixedBuffer = AudioMixer().fix(convertedBuffer)

        return fixedBuffer
    }
}