package org.example.Behavioral.TemplateMethod

import java.io.File

class CsvDataMiner : DataMinerTemplate() {
    override fun extractData(path: String): String {
        return File(path).readText(Charsets.UTF_8).also {
            println(it)
        }
    }

    override fun parseData(buffer: String): String = buffer
}