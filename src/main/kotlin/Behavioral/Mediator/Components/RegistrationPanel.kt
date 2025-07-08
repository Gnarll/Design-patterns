package org.example.Behavioral.Mediator.Components

import org.example.Behavioral.Mediator.AuthEvent
import org.example.Behavioral.Mediator.Mediator
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField


class RegistrationPanel(override val mediator: Mediator) : MyComponent, JPanel() {

    val loginField: JTextField
    val passwordField: JPasswordField

    init {
        loginField = JTextField(15)
        passwordField = JPasswordField(15)
        val actionButton = JButton("Registration")

        layout = GridBagLayout()
        val gbc = GridBagConstraints().apply {
            insets = Insets(5, 5, 5, 5)
            anchor = GridBagConstraints.WEST
            fill = GridBagConstraints.HORIZONTAL
            gridx = 0
            gridy = 0
        }

        add(loginField, gbc)
        gbc.gridy++
        add(passwordField, gbc)
        gbc.gridy++

        gbc.fill = GridBagConstraints.NONE
        gbc.anchor = GridBagConstraints.CENTER

        actionButton.text = "Register"
        actionButton.addActionListener {
            mediator.notify(sender = this, event = AuthEvent.REGISTER)
        }
        this.add(actionButton, gbc)
    }

}