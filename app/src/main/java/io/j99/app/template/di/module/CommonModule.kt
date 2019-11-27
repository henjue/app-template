package io.j99.app.template.di.module

import android.app.Application
import androidx.room.Room
import com.chaoran.winemarket.di.DatabaseInfo
import com.chaoran.winemarket.di.HttpCache
import com.google.gson.*
import dagger.Module
import dagger.Provides
import io.j99.app.template.db.AppDatabase
import java.io.File
import java.lang.reflect.Modifier
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

@Module
class CommonModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Date::class.java, DateAdapter())
            .setPrettyPrinting()
            .excludeFieldsWithModifiers(
                Modifier.PUBLIC,
                Modifier.STATIC,
                Modifier.TRANSIENT,
                Modifier.VOLATILE
            )
            .create()
    }

    @HttpCache
    @Provides
    @Singleton
    fun provideHttpCacheDir(application: Application): File {
        val httpCacheDir = File(application.cacheDir, "http_caches")
        if (httpCacheDir.exists().not()) {
            httpCacheDir.mkdirs()
        }
        return httpCacheDir
    }



}

class DateAdapter : JsonSerializer<Date>, JsonDeserializer<Date> {
    override fun serialize(
        src: Date?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(
            SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss",
                Locale.getDefault()
            ).format(src)
        )
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date {
        json?.asString.let {
            return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(it)
        }
    }
}