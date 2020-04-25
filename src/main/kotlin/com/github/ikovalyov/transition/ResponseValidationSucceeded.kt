package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class ResponseValidationSucceeded : TransitionInterface<State.ResponseValidationFinished, State.SuccessState> {
    override fun guard(stateFrom: State): Boolean {
        return stateFrom is State.ResponseValidationFinished && stateFrom.responseValidationResult
    }

    override fun invoke(stateFrom: State.ResponseValidationFinished): State.SuccessState {
        val message = when (stateFrom.parentState) {
            is State.SearchDataReceived -> stateFrom.parentState.searchData
            is State.SuggestDataReceived -> stateFrom.parentState.suggestData
            else -> throw IllegalStateException("Unknown state")
        }
        return State.SuccessState("Successfully received $message", stateFrom)
    }
}