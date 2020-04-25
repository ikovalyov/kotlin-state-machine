package com.github.ikovalyov.transition

import com.github.ikovalyov.state.State

class ReceiveSuggestData : TransitionInterface<State.RequestValidationFinished, State.SuggestDataReceived> {
    override fun guard(stateFrom: State): Boolean {
        return stateFrom is State.RequestValidationFinished &&
                stateFrom.requestValidationResult &&
                stateFrom.parentState is State.SuggestRequestReceived
    }

    override fun invoke(stateFrom: State.RequestValidationFinished): State.SuggestDataReceived {
        return State.SuggestDataReceived("suggest data", stateFrom)
    }
}