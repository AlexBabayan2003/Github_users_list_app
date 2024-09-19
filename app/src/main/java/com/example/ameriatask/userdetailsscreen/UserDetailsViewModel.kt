package com.example.ameriatask.userdetailsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ameriatask.repo.GithubRepository
import com.example.ameriatask.data.GithubUserDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: GithubRepository,
) : ViewModel() {
    private val _user = MutableStateFlow<GithubUserDetails?>(null)
    val user: StateFlow<GithubUserDetails?> = _user

    fun getUserDetails(username: String) {
        viewModelScope.launch {
            val response = repository.getUserDetails(username)
            _user.value = response
        }
    }
}
