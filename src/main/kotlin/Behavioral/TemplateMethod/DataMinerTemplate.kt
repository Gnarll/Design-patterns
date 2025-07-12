package org.example.Behavioral.TemplateMethod


// main idea is to extract the common logic into template function
// use common methods there and override unique methods
abstract class DataMinerTemplate {
    fun mine(path: String, keyWord: String): Int {
        val buffer = extractData(path)
        val text = parseData(buffer)
        val numOfWords = analyzeData(text, keyWord)

        return numOfWords
    }

    abstract fun extractData(path: String): String

    abstract fun parseData(buffer: String): String

    private fun analyzeData(string: String, keyWord: String): Int = string.split(keyWord).size - 1
}