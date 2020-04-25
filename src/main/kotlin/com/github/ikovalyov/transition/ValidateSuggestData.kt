package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class ValidateSuggestData : TransitionInterface<State.SuggestDataReceived, State.ResponseValidationFinished> {
    override fun guard(stateFrom: State): Boolean {
        return stateFrom is State.SuggestDataReceived
    }

    override fun invoke(stateFrom: State.SuggestDataReceived): State.ResponseValidationFinished {
        return State.ResponseValidationFinished(stateFrom.suggestData.isNotEmpty(), stateFrom)
    }
}