package org.example.Structural.Adapter

interface XMLManipulator {
    fun validateData(xmlStr: String): String
    fun saveToFile(xmlStr: String): Unit
    fun drawGraph(xmlStr: String): Unit
}

// That is an App's main class (client), all the functionality
// of which deals only with XML-objects

class XMLDataManager(private val dataAnalyzer: DataAnalyzer) : XMLManipulator {
    override fun validateData(xmlStr: String): String {
        // validation process
        return xmlStr
    }

    override fun saveToFile(xmlStr: String) {
        println("$xmlStr saved to file")
    }

    override fun drawGraph(xmlStr: String) {
        println("Drawing a graph of $xmlStr")
    }

    fun makeAnalysis(xmlString: String) {
        dataAnalyzer.makeAnalysis(xmlString)
    }
}