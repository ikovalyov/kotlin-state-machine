package com.github.ikovalyov

import com.github.ikovalyov.state.State
import com.github.ikovalyov.transition.TransitionInterface

class StateMachine(val transitions: List<TransitionInterface<*, *>>) {
    inline fun <reified S: State>performTransition(state: S): State {
        val transition = transitions.filter {
            it.guard(state)
        }.filterIsInstance<TransitionInterface<S, *>>().first()
        return transition(state)
    }
}