package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class ResponseValidationFailed : TransitionInterface<State.ResponseValidationFinished, State.FailedState> {
    override fun guard(stateFrom: State): Boolean {
        return stateFrom is State.ResponseValidationFinished && !stateFrom.responseValidationResult
    }

    override fun invoke(stateFrom: State.ResponseValidationFinished): State.FailedState {
        return State.FailedState("Response validation failed", stateFrom)
    }
}