package com.example.ameriatask.userdetailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.ameriatask.data.GithubUserDetails

@Composable
fun UserDetailScreen(
    username: String,
    viewModel: UserDetailsViewModel = hiltViewModel(),
) {


    val user: GithubUserDetails? by viewModel.user.collectAsState()
    LaunchedEffect(key1 = username) {
        viewModel.getUserDetails(username)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        if (user != null) {
            user?.run {
                Image(
                    painter = rememberAsyncImagePainter(avatarUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                )
                Text(text = name ?: "No name", style = MaterialTheme.typography.headlineLarge)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location Icon",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = location ?: "Unknown location",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Followers and Following
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Followers: $followers")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Following: $following")
                }

                Spacer(modifier = Modifier.height(16.dp))
                Column(horizontalAlignment = Alignment.Start) {
                    bio?.let {
                        Text(text = "Bio: \n$it", style = MaterialTheme.typography.bodyLarge)
                    }
                    publicRepos?.let {
                        Text(text = "Public Repos: \n$it")
                    }
                    publicGists?.let {
                        Text(text = "Public Gists: \n$it")
                    }
                    updatedAt?.let {
                        Text(text = "Updated at: \n$it")
                    }
                }

            }
        } else CircularProgressIndicator()
    }
}
