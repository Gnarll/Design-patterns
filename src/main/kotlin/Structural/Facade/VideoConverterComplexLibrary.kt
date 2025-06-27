package org.example.Structural.Facade


// 3rd party complex lib for video conversion

class VideoFile(private val filename: String) {
    private val format = filename.substringAfterLast('.', "")

    fun getFormat(): String = format

    fun getFilename(): String = filename
}

interface Codec {
    val type: String
    fun compress(buffer: ByteArray): ByteArray
}

class OggCompressionCodec : Codec {
    override val type: String = "ogg"

    override fun compress(buffer: ByteArray): ByteArray {
        println("Compressing audio data with Ogg codec")
        return buffer.copyOf(buffer.size / 2)
    }
}

class MPEG4CompressionCodec : Codec {
    override val type: String = "mp4"

    override fun compress(buffer: ByteArray): ByteArray {
        println("Compressing video data with MPEG4 codec")
        return buffer.copyOf(buffer.size / 3)
    }
}

class CodecFactory {
    companion object {
        fun extract(file: VideoFile): Codec {
            return when (file.getFormat()) {
                "ogg" -> OggCompressionCodec()
                "mp4" -> MPEG4CompressionCodec()
                else -> throw IllegalArgumentException("Unsupported format: ${file.getFormat()}")
            }
        }
    }
}

class BitrateReader {
    companion object {
        fun read(filename: String, sourceCodec: Codec): ByteArray {
            println("Reading file '$filename' with ${sourceCodec.type} codec")
            return ByteArray(1024)
        }

        fun convert(buffer: ByteArray, destinationCodec: Codec): ByteArray {
            println("Converting from ${buffer.size} bytes using ${destinationCodec.type} codec")
            return destinationCodec.compress(buffer)
        }
    }
}

class AudioMixer {
    fun fix(buffer: ByteArray): ByteArray {
        println("Fixing audio data")
        return buffer.copyOf(buffer.size + 100)
    }
}