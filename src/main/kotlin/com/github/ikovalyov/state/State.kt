package com.github.ikovalyov.state

sealed class State(val parentState: State?) {
    class SearchRequestReceived(val searchRequest: String): State(null), EntryState
    class SuggestRequestReceived(val suggestRequest: String): State(null), EntryState
    class RequestValidationFinished(val requestValidationResult: Boolean, parentState: State): State(parentState)
    class SearchDataReceived(val searchData: String, parentState: RequestValidationFinished): State(parentState)
    class SuggestDataReceived(val suggestData: String, parentState: RequestValidationFinished): State(parentState)
    class ResponseValidationFinished(val responseValidationResult: Boolean, parentState: State): State(parentState)
    class SuccessState(override val message: String, parentState: ResponseValidationFinished): State(parentState), ExitState
    class FailedState(override val message: String, parentState: State): State(parentState), ExitState
}