package org.example.Structural.Adapter

import org.example.PatternExecutor

class AdapterExecutor: PatternExecutor {
    override fun main() {
        val xmlString = XMLDataProvider.fetchData()

        val jsonAnalyzer = JSONAnalyzer()
        val jsonAdapter: DataAnalyzer = JSONAnalyzerAdapter(jsonAnalyzer)

        val xmlDataManager = XMLDataManager(jsonAdapter)

        xmlDataManager.validateData(xmlString)
        xmlDataManager.drawGraph(xmlString)
        xmlDataManager.saveToFile(xmlString)

        xmlDataManager.makeAnalysis(xmlString)
    }
}