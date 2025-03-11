package org.example.Structural.Composite

import org.example.PatternExecutor
import org.example.Structural.Composite.Shapes.Circle
import org.example.Structural.Composite.Shapes.CompoundShape
import org.example.Structural.Composite.Shapes.Dot
import org.example.Structural.Composite.Shapes.Rectangle
import org.example.Structural.Composite.editor.ImageEditor
import java.awt.Color


class CompositeExecutor : PatternExecutor {
    override fun main() {

        val editor = ImageEditor(
            CompoundShape(
                listOf(
                    Circle(10, 10, 10, Color.BLUE),
                    Rectangle(100, 100, 120, 120, Color.GREEN),
                    CompoundShape(
                        listOf(
                            Circle(110, 110, 50, Color.RED),
                            Dot(160, 160, Color.RED),

                            )
                    ),
                    CompoundShape(
                        listOf(
                            Rectangle(250, 250, 100, 100, Color.GREEN),
                            Dot(240, 240, Color.GREEN),
                            Dot(240, 360, Color.GREEN),
                            Dot(360, 360, Color.GREEN),
                            Dot(360, 240, Color.GREEN)
                        )
                    )
                )

            )
        )


    }
}