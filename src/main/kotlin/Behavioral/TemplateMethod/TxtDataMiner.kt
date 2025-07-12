package org.example.Behavioral.TemplateMethod

import java.io.File

class TxtDataMiner : DataMinerTemplate() {
    override fun extractData(path: String): String {
        return File(path).readText(Charsets.UTF_8)
    }

    override fun parseData(buffer: String): String = buffer
}