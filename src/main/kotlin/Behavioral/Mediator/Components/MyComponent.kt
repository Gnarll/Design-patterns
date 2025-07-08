package org.example.Behavioral.Mediator.Components

import org.example.Behavioral.Mediator.Mediator

// Has such a name, cause awt lib already has Component class
interface MyComponent {
    val mediator: Mediator
}