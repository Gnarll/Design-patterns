package org.example.Structural.Composite.editor

import org.example.Structural.Composite.Shapes.BaseShape
import org.example.Structural.Composite.Shapes.CompoundShape
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.BorderFactory
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants


class ImageEditor(private val allShapes: CompoundShape) {
    private val canvas: EditorCanvas = EditorCanvas()

    fun loadShapes(shapes: List<BaseShape>) {
        allShapes.clear()
        allShapes.add(shapes)
        canvas.refresh()
    }

    private inner class EditorCanvas : Canvas() {
        private val PADDING = 10

        private lateinit var frame: JFrame

        init {
            createFrame()
            refresh()
            addMouseListener(
                object : MouseAdapter() {
                    override fun mousePressed(e: MouseEvent) {
                        allShapes.unselect()
                        allShapes.selectChildAt(e.x, e.y)
                        e.component.repaint()
                    }
                }
            )
        }

        fun createFrame() {
            frame = JFrame()
            frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            frame.setLocationRelativeTo(null)

            val contentPanel = JPanel()
            val padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING)
            contentPanel.border = padding
            frame.contentPane = contentPanel

            frame.add(this)
            frame.isVisible = true
            frame.contentPane.background = Color.LIGHT_GRAY
        }

        override fun getHeight(): Int {
            return allShapes.getHeight() + allShapes.getY() + PADDING
        }

        override fun getWidth(): Int {
            return allShapes.getWidth() + allShapes.getY() + PADDING
        }

        fun refresh() {
            this.setSize(width, height)
            frame.pack()
        }

        override fun paint(graphics: Graphics) {
            allShapes.paint(graphics)
        }
    }
}