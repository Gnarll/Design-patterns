import org.example.Behavioral.Memento.Caretaker
import org.example.Behavioral.Memento.DotModel
import org.example.Behavioral.Memento.DotView
import org.example.Behavioral.Memento.UiState
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class DotController : JFrame() {
    private val model = DotModel(UiState(200, 200, 10, 10))
    private val caretaker = Caretaker()
    private val view = DotView(model)

    init {
        title = "Dot Drawer (Memento Pattern)"
        defaultCloseOperation = EXIT_ON_CLOSE
        layout = BoxLayout(contentPane, BoxLayout.Y_AXIS)

        val buttonPanel = JPanel()

        val incBtn = JButton("Increase")
        incBtn.addActionListener {
            caretaker.save(model.createSnapshot())
            model.resize(5)
            view.repaint()
        }

        val decBtn = JButton("Decrease")
        decBtn.addActionListener {
            caretaker.save(model.createSnapshot())
            model.resize(-5)
            view.repaint()
        }

        val undoBtn = JButton("Undo")
        undoBtn.addActionListener {
            caretaker.undo()?.let {
                model.restore(it)
                view.repaint()
            }
        }

        buttonPanel.add(incBtn)
        buttonPanel.add(decBtn)
        buttonPanel.add(undoBtn)

        view.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                caretaker.save(model.createSnapshot())
                model.moveTo(e.x, e.y)
                view.repaint()
            }
        })

        add(buttonPanel)
        add(view)
        pack()
        isVisible = true
    }
}