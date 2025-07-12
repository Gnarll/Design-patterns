package org.example.Behavioral.TemplateMethod

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import java.io.File

class PdfDataMiner : DataMinerTemplate() {
    override fun extractData(path: String): String {
        val document = PDDocument.load(File(path))
        return try {
            val stripper = PDFTextStripper()
            stripper.getText(document)
        } finally {
            document.close()
        }
    }

    override fun parseData(buffer: String): String = buffer
}