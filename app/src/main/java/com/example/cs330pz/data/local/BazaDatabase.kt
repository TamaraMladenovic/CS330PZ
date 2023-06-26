package com.example.cs330pz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cs330pz.data.local.converters.StringListTypeConverter
import com.example.cs330pz.data.local.dao.DogadjajiDao
import com.example.cs330pz.domain.model.Dogadjaji
import com.example.cs330pz.domain.model.Problemi


@Database(
    entities = [Dogadjaji::class, Problemi::class],
    version = 1,
    exportSchema = true
)
abstract class BazaDatabase: RoomDatabase() {
    abstract fun dogadjajDao(): DogadjajiDao
}