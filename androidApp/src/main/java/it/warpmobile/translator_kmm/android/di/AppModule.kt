package it.warpmobile.translator_kmm.android.di

import android.app.Application
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import it.warpmobile.translator_kmm.database.TranslateDatabase
import it.warpmobile.translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import it.warpmobile.translator_kmm.translate.data.local.DatabaseDriverFactory
import it.warpmobile.translator_kmm.translate.data.remote.HttpClientFactory
import it.warpmobile.translator_kmm.translate.data.translate.KtorTranslateClient
import it.warpmobile.translator_kmm.translate.domain.history.HistoryDataSource
import it.warpmobile.translator_kmm.translate.domain.translate.Translate
import it.warpmobile.translator_kmm.translate.domain.translate.TranslateClient
import java.net.HttpCookie
import javax.inject.Singleton

/**
 * @author Giuseppe Sorce
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient() :HttpClient{
       return HttpClientFactory().create()

    }

   @Provides
   @Singleton
   fun provideTranslationClient(httpClient: HttpClient) :TranslateClient{

      return  KtorTranslateClient(httpClient)
   }

   @Provides
   @Singleton
   fun provideDatabaseDriverFactory(app: Application) : SqlDriver{

      return  DatabaseDriverFactory(app).create()
   }

   @Provides
   @Singleton
   fun provideHistoryDataSource(driver: SqlDriver) : HistoryDataSource{

      return  SqlDelightHistoryDataSource(TranslateDatabase(driver))
   }


    @Provides
    @Singleton
    fun provideTranslateUseCase(client : TranslateClient, dataSource: HistoryDataSource) : Translate{

        return  Translate(client, dataSource)
    }

}