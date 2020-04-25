package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

interface TransitionInterface<I: State, O: State> {
    fun guard(stateFrom: State) : Boolean
    operator fun invoke(stateFrom: I): O
}