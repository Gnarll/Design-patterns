package org.example.Behavioral.TemplateMethod

import org.example.PatternExecutor

class TemplateMethodExecutor : PatternExecutor {
    override fun main() {
        val pdfMiner = PdfDataMiner()
        var occurrences = pdfMiner.mine("src/main/kotlin/Behavioral/TemplateMethod/test.pdf", "Lorem")
        println(occurrences)

        val txtDataMiner = TxtDataMiner()
        occurrences = txtDataMiner.mine("src/main/kotlin/Behavioral/TemplateMethod/test.txt", "Lorem")
        println(occurrences)

        val csvDataMiner = CsvDataMiner()
        occurrences = csvDataMiner.mine("src/main/kotlin/Behavioral/TemplateMethod/test.csv", "@")
        println(occurrences)
    }

}