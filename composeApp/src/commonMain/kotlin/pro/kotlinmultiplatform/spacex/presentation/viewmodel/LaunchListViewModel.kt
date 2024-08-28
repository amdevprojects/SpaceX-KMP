package pro.kotlinmultiplatform.spacex.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pro.kotlinmultiplatform.spacex.domain.usecase.GetLaunchListUseCase
import pro.kotlinmultiplatform.spacex.presentation.state.LaunchListUiState
import pro.kotlinmultiplatform.spacex.presentation.state.ScreenState
import pro.kotlinmultiplatform.spacex.presentation.state.toUiModel

class LaunchListViewModel(
    private val getLaunchListUseCase: GetLaunchListUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow(LaunchListUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getLaunchList()
    }

    private fun getLaunchList() {
        _uiState.update { state ->
            state.copy(
                screenState = ScreenState.Loading,
            )
        }

        viewModelScope.launch {
            val result = getLaunchListUseCase.execute()
            _uiState.update { state ->
                state.copy(
                    screenState = ScreenState.Content,
                    launchList = result.map { it.toUiModel() }
                )
            }
        }
    }
}