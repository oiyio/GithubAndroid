package com.omeriyioz.github_android.features.fragment1

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
import com.omeriyioz.github_android.features.centerTextHorizontallyModifier

@Composable
fun RepoScreen(
    viewModel1: ViewModel1,
    searchedUsername: String
) {
    val repoDTOListState by viewModel1.repoDTOList.observeAsState(initial = emptyList())
    viewModel1.getRepoDTOList(searchedUsername)

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "List of Repositories(${repoDTOListState.size} total) : ",
            modifier = centerTextHorizontallyModifier
        )
        Divider(color = Color.Red)

        LazyColumn(
            content = {
                items(repoDTOListState) { repoDTO ->
                    Text(
                        "Name : ${repoDTO.name} - " +
                            "RepoId : ${repoDTO.repoId} - " +
                            "Stars : ${repoDTO.stars} - " +
                            "IssueCount : ${repoDTO.issueCount} - " +
                            "owner.login : ${repoDTO.owner?.login} - " +
                            "owner.avatarUrl : ${repoDTO.owner?.avatarUrl} - " +
                            "owner.ownerId : ${repoDTO.owner?.ownerId} - "
                    )

                    Divider(color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        )
    }
}
