/**
 * Author: chenjin
 * Date: 2019-11-26 17:03
 * Description:
 */
package io.j99.app.template.di.module

import com.chaoran.winemarket.di.DatabaseInfo
import dagger.Module
import dagger.Provides

@Module
class StringModule {
    @Provides
    @DatabaseInfo
    fun databaseName(): String {
        return "app_template_database"
    }
}