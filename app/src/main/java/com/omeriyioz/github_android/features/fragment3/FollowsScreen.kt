package com.omeriyioz.github_android.features.fragment3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.omeriyioz.github_android.features.centerTextHorizontallyModifier

@Composable
fun FollowsScreen(
    viewModel3: ViewModel3 = hiltViewModel(),
    searchedUsername: String
) {
    val followerList by viewModel3.followerList.observeAsState(initial = emptyList())
    val followingList by viewModel3.followingList.observeAsState(initial = emptyList())
    viewModel3.getFollows(searchedUsername)

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "List of Followers(${followerList.size} total) : ",
            modifier = centerTextHorizontallyModifier
        )
        Divider(color = Color.Red)

        LazyColumn(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            content = {
                items(followerList) { follower ->
                    Text(
                        "Name : ${follower.login} - " +
                            "RepoId : ${follower.id} - " +
                            "Stars : ${follower.avatar_url} - "
                    )
                    Divider(color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text("List of Followings(${followingList.size} total) : ")
        Divider(color = Color.Red)
        LazyColumn(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            content = {
                items(followingList) { following ->
                    Text(
                        "Name : ${following.login} - " +
                            "RepoId : ${following.id} - " +
                            "Stars : ${following.avatar_url} - "
                    )
                    Divider(color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        )
    }
}
