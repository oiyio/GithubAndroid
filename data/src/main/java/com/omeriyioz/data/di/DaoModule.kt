package com.omeriyioz.data.di

import android.content.Context
import androidx.room.Room
import com.omeriyioz.data.database.GithubDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext context: Context
    ): GithubDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            GithubDatabase::class.java,
            "github_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideYourDao(db: GithubDatabase) = db.githubDao
}
