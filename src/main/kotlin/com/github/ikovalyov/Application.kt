package com.github.ikovalyov

import com.github.ikovalyov.state.ExitState
import com.github.ikovalyov.state.State
import com.github.ikovalyov.transition.*

        class Application {
            companion object{
                @JvmStatic
                fun main(args: Array<String>) {
                    val sm = StateMachine(
                        listOf(
                            PrepareRequestValidationFailed(),
                            ReceiveSearchData(),
                            ReceiveSuggestData(),
                            RequestValidationFailed(),
                            ResponseValidationFailed(),
                            ResponseValidationSucceeded(),
                            ValidateSearchData(),
                            ValidateSearchRequest(),
                            ValidateSuggestData(),
                            ValidateSuggestRequest()
                        )
                    )
                    var initialState: State = State.SearchRequestReceived("search request")
                    var finalState: ExitState = executeSM(initialState, sm)
                    require(finalState.message == "Successfully received search data")

                    initialState = State.SuggestRequestReceived("suggest request")
                    finalState = executeSM(initialState, sm)
                    require(finalState.message == "Successfully received suggest data")

                    initialState = State.SuggestRequestReceived("")
                    finalState = executeSM(initialState, sm)
                    require(finalState.message == "Request validation failed")
                }

                private fun executeSM(
                    initialState: State,
                    sm: StateMachine
                ): ExitState {
                    var nextState: State = initialState
                    while (nextState !is ExitState) {
                        nextState = sm.performTransition(nextState)
                    }
                    return nextState
                }
            }
        }