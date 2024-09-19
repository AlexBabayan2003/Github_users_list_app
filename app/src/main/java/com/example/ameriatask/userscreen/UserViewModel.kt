package com.example.ameriatask.userscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ameriatask.repo.GithubRepository
import com.example.ameriatask.data.GithubUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: GithubRepository,
) : ViewModel() {
    private val _users = MutableStateFlow<List<GithubUser>>(emptyList())
    val users: StateFlow<List<GithubUser>> = _users

    init {
        viewModelScope.launch {
            val response = repository.getUsers()
            _users.value = response
        }
    }
}
