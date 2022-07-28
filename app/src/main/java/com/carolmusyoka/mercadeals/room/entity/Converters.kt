package com.carolmusyoka.mercadeals.room.entity

import androidx.room.TypeConverter
import com.carolmusyoka.mercadeals.domain.model.Rating
import org.json.JSONObject


class Converters {
    @TypeConverter
    fun fromRating(rating: Rating): String {
        return JSONObject().apply {
            put("count", rating.count)
            put("rate", rating.rate)
        }.toString()
    }

    @TypeConverter
    fun toSource(rating: String): Rating {
        val json = JSONObject(rating)
        return Rating(json.get("count") as Int, json.getDouble("rate"))
    }
}