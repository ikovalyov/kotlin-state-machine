package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class ValidateSearchRequest : TransitionInterface<State.SearchRequestReceived, State.RequestValidationFinished> {
    override fun guard(stateFrom: State) = stateFrom is State.SearchRequestReceived

    override fun invoke(stateFrom: State.SearchRequestReceived): State.RequestValidationFinished {
        val message = stateFrom.searchRequest
        val validationResult = message.isNotEmpty()
        return State.RequestValidationFinished(validationResult, stateFrom)
    }
}