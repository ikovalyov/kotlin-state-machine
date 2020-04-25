package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class ValidateSuggestRequest : TransitionInterface<State.SuggestRequestReceived, State.RequestValidationFinished> {
    override fun guard(stateFrom: State) = stateFrom is State.SuggestRequestReceived

    override fun invoke(stateFrom: State.SuggestRequestReceived): State.RequestValidationFinished {
        val message = stateFrom.suggestRequest
        val validationResult = message.isNotEmpty()
        return State.RequestValidationFinished(validationResult, stateFrom)
    }
}