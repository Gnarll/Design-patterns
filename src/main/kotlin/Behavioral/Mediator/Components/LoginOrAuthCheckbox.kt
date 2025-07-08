package org.example.Behavioral.Mediator.Components

import org.example.Behavioral.Mediator.AuthEvent
import org.example.Behavioral.Mediator.Mediator
import javax.swing.JCheckBox

class LoginOrAuthCheckbox(
    override val mediator: Mediator
) : MyComponent, JCheckBox("Enable registration mode", false) {
    init {
        addActionListener {
            if (isSelected) {
                mediator.notify(this, AuthEvent.SET_REGISTRATION_MODE)

            } else {
                mediator.notify(this, AuthEvent.SET_LOGIN_MODE)
            }
        }
    }

}