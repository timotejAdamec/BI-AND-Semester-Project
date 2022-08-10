package cz.cvut.fit.adametim.spacex_crew.features.crew.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewRepository
import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CrewViewModel(
    private val crewRepository: CrewRepository
) : ViewModel() {

    private val _crewStateStream = MutableStateFlow<CrewState>(CrewState.Loading)
    val crewStateStream = _crewStateStream.asStateFlow()

    init {
        viewModelScope.launch {
            loadCrew()
        }
        viewModelScope.launch {
            fetchCrew()
        }
    }

    private suspend fun loadCrew() {
        crewRepository.getCrewStream().collect { crew ->
            _crewStateStream.value = CrewState.Loaded(crew = crew)
        }
    }

    private suspend fun fetchCrew() {
        try {
            crewRepository.fetchCrew()
        } catch (t: Throwable) {
            _crewStateStream.value = CrewState.Error(throwable = t)
        }
    }
}

sealed class CrewState {

    object Loading : CrewState()

    data class Loaded(val crew: List<CrewMember>) : CrewState()

    data class Error(val throwable: Throwable) : CrewState()
}