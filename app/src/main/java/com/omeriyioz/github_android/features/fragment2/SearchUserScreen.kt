package com.omeriyioz.github_android.features.fragment2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

@Composable
fun SearchUserScreen(
    viewModel2: ViewModel2,
    searchedUsername: String
) {
    val userResponseDTO by viewModel2.userResponseDTO.observeAsState()
    val userDetailResponseDTO by viewModel2.userDetailResponseDTO.observeAsState()
    viewModel2.searchUsers(searchedUsername)

    Column(modifier = Modifier.fillMaxSize()) {

        Text("List of Users(${userResponseDTO?.total_count}) : ")
        Divider(color = Color.Red)

        userResponseDTO?.items?.let { userList ->
            LazyColumn(
                content = {
                    items(userList) { user ->
                        Text(
                            "avatar_url : ${user.avatar_url} - " +
                                "id : ${user.id} - " +
                                "login : ${user.login} - "
                        )

                        Divider(color = Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            )
        }

        Divider(color = Color.Green)
        Spacer(modifier = Modifier.height(18.dp))

        // user detail below :
        Text("Details of User oiyio: ")
        Divider(color = Color.Red)
        userDetailResponseDTO?.let {
            Text(
                "avatar_url : ${it.avatar_url} - " +
                    "id : ${it.name} - " +
                    "login : ${it.login} - "
            )

            Divider(color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
