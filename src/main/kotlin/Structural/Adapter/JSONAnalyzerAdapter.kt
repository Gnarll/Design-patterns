package org.example.Structural.Adapter

import org.json.XML


interface DataAnalyzer {
    fun makeAnalysis(xmlString: String): Unit
}

// that's an Adapter class for JSON lib, which allows
// the client class to analyze data via itself

class JSONAnalyzerAdapter(private val jsonAnalyzer: JSONAnalyzer): DataAnalyzer {
    override fun makeAnalysis(xmlString: String) {
        val jsonObject = XML.toJSONObject(xmlString)
        val jsonString = jsonObject.toString(4)

        jsonAnalyzer.makeJSONAnalysis(jsonString)
    }
}