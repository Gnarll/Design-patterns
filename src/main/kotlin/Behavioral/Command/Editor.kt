package org.example.Behavioral.Command

import java.awt.event.ActionEvent
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.text.JTextComponent


// for implementing pattern was decided not to
// use out of the box functions of swing
// and just to use the simplest features e.g.
// getting the selected text
class Editor(
    onCopyButtonClick: () -> Unit = {},
    onCutButtonClick: () -> Unit = {},
    onPasteButtonClick: () -> Unit = {},
    onUndoButtonClick: () -> Unit = {},
    onCopyShortcutExecute: () -> Unit = {},
    onCutShortcutExecute: () -> Unit = {},
    onPasteShortcutExecute: () -> Unit = {},
    onUndoShortcutExecute: () -> Unit = {},
    onChangeText: () -> Unit = {}
) : JFrame("Simple Text Editor") {

    private val textArea = JTextArea()

    var text: String
        get() = textArea.text
        set(value) {
            textArea.text = value
        }


    fun getSelection(): String = textArea.selectedText ?: ""

    fun deleteSelection() {
        textArea.replaceSelection("")
    }

    fun replaceSelection(text: String) {
        textArea.replaceSelection(text)
    }

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(500, 400)

        val buttonPanel = JPanel()


        val scrollPane = JScrollPane(textArea)

        val copyButton = JButton("Copy")
        val cutButton = JButton("Cut")
        val pasteButton = JButton("Paste")
        val undoButton = JButton("Undo")

        buttonPanel.add(copyButton)
        buttonPanel.add(cutButton)
        buttonPanel.add(pasteButton)
        buttonPanel.add(undoButton)

        layout = BoxLayout(contentPane, BoxLayout.Y_AXIS)
        add(buttonPanel)
        add(scrollPane)

        textArea.addKeyListener(object : KeyAdapter() {
            override fun keyTyped(e: KeyEvent?) {
                onChangeText()
            }
        })

        copyButton.addActionListener {
            onCopyButtonClick()
        }

        cutButton.addActionListener {
            onCutButtonClick()
        }

        pasteButton.addActionListener {
            onPasteButtonClick()
        }

        undoButton.addActionListener {
            onUndoButtonClick()
        }

        setupHotKey(textArea, KeyEvent.VK_1, "ctrl1") { onCopyShortcutExecute() }
        setupHotKey(textArea, KeyEvent.VK_2, "ctrl2") { onCutShortcutExecute() }
        setupHotKey(textArea, KeyEvent.VK_3, "ctrl3") { onPasteShortcutExecute() }
        setupHotKey(textArea, KeyEvent.VK_4, "ctrl4") { onUndoShortcutExecute() }

        isVisible = true

    }

    private fun setupHotKey(
        component: JTextComponent,
        keyCode: Int,
        actionKey: String,
        action: () -> Unit
    ) {
        val inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        val actionMap = component.actionMap

        inputMap.put(KeyStroke.getKeyStroke(keyCode, KeyEvent.CTRL_DOWN_MASK), actionKey)
        actionMap.put(actionKey, object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent) {
                action()
            }
        })
    }

}