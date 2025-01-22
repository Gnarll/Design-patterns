package org.example.Structural.Adapter

// hidden interface of many possible, but this
// functionality we exactly want to adapt

interface JSONManipulator {
    fun makeJSONAnalysis(jsonString: String): Unit
}

// this is a 3rd party library (service),
// the implementation of which we do not have access to

class JSONAnalyzer: JSONManipulator {
    override fun makeJSONAnalysis(jsonString: String) {
        println("$jsonString is being analyzed")
    }
}