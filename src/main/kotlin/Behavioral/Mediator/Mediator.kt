package org.example.Behavioral.Mediator

import org.example.Behavioral.Mediator.Components.LoginOrAuthCheckbox
import org.example.Behavioral.Mediator.Components.LoginPanel
import org.example.Behavioral.Mediator.Components.MyComponent
import org.example.Behavioral.Mediator.Components.RegistrationPanel
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Font
import javax.swing.*


enum class AuthEvent {
    SET_LOGIN_MODE,
    SET_REGISTRATION_MODE,
    LOGIN,
    REGISTER,
}

interface Mediator {
    fun notify(sender: MyComponent, event: AuthEvent)
}

// Not sure if it either a good implementation or good pattern at all
class AuthDialog(private val userDb: UserDatabase = UserDatabaseImpl()) : Mediator {
    private val frame: JFrame = JFrame("Auth Panel")
    private val mainPanel: JPanel

    private val titleLabel: JLabel

    private val switchModeCheckBox: JCheckBox = LoginOrAuthCheckbox(this)
    private val loginPanel: JPanel = LoginPanel(this)
    private val registrationPanel: JPanel = RegistrationPanel(this)


    init {
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.size = Dimension(350, 200)

        mainPanel = JPanel().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
        }

        titleLabel = JLabel("Login").apply {
            font = font.deriveFont(Font.BOLD, 16f)
        }
        val labelPanel = JPanel(FlowLayout(FlowLayout.CENTER)).apply {
            add(titleLabel)
        }

        val checkBoxPanel = JPanel(FlowLayout(FlowLayout.CENTER)).apply {
            add(switchModeCheckBox)
        }

        mainPanel.add(labelPanel)
        mainPanel.add(checkBoxPanel)
        mainPanel.add(loginPanel)

        frame.contentPane.add(mainPanel)
        frame.isVisible = true
    }

    override fun notify(sender: MyComponent, event: AuthEvent) {
        if (event == AuthEvent.SET_LOGIN_MODE || event == AuthEvent.SET_REGISTRATION_MODE) {
            changeAuthMode(event = event)
        }

        if (event == AuthEvent.LOGIN && sender is LoginPanel) {
            val login = sender.loginField.text
            val password = sender.passwordField.password.concatToString()

            if (userDb.checkForUser(User(login = login, password = password))) {
                JOptionPane.showMessageDialog(frame, "Successfully logged in")
            } else {
                JOptionPane.showMessageDialog(frame, "User not found")
            }
        }

        if (event == AuthEvent.REGISTER && sender is RegistrationPanel) {
            val login = sender.loginField.text
            val password = sender.passwordField.password.concatToString()

            if (userDb.insertUser(User(login = login, password = password))) {
                JOptionPane.showMessageDialog(frame, "Successfully registered")
            } else {
                JOptionPane.showMessageDialog(frame, "User exists")
            }
        }

    }

    private fun changeAuthMode(event: AuthEvent) {
        mainPanel.remove(loginPanel)
        mainPanel.remove(registrationPanel)

        when (event) {
            AuthEvent.SET_LOGIN_MODE -> {
                titleLabel.text = "Authentication"
                mainPanel.add(loginPanel)
            }

            AuthEvent.SET_REGISTRATION_MODE -> {
                titleLabel.text = "Registration"
                mainPanel.add(registrationPanel)
            }

            else -> {
                throw RuntimeException("No such Auth mode")
            }
        }

        mainPanel.revalidate()
        mainPanel.repaint()

    }

}