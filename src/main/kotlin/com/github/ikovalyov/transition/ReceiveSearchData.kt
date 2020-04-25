package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class ReceiveSearchData : TransitionInterface<State.RequestValidationFinished, State.SearchDataReceived> {
    override fun guard(stateFrom: State): Boolean {
        return stateFrom is State.RequestValidationFinished &&
                stateFrom.requestValidationResult &&
                stateFrom.parentState is State.SearchRequestReceived
    }

    override fun invoke(stateFrom: State.RequestValidationFinished): State.SearchDataReceived {
        return State.SearchDataReceived("search data", stateFrom)
    }
}