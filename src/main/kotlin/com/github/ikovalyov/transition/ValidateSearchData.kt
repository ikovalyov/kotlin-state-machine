package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class ValidateSearchData : TransitionInterface<State.SearchDataReceived, State.ResponseValidationFinished> {
    override fun guard(stateFrom: State): Boolean {
        return stateFrom is State.SearchDataReceived
    }

    override fun invoke(stateFrom: State.SearchDataReceived): State.ResponseValidationFinished {
        return State.ResponseValidationFinished(stateFrom.searchData.isNotEmpty(), stateFrom)
    }
}