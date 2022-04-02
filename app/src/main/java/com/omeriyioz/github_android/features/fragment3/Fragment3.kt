package com.omeriyioz.github_android.features.fragment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.omeriyioz.github_android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Fragment3 : Fragment(R.layout.fragment_compose_view) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_compose_view, container, false).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {

                FollowsScreen()

            }
        }
    }

}
