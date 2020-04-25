package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class PrepareRequestValidationFailed : TransitionInterface<State.RequestValidationFinished, State.FailedState> {
    override fun guard(stateFrom: State): Boolean {
        return stateFrom is State.RequestValidationFinished && !stateFrom.requestValidationResult
    }

    override fun invoke(stateFrom: State.RequestValidationFinished): State.FailedState {
        return State.FailedState("Request validation failed", stateFrom)
    }
}