package com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.db

import android.content.Context
import android.content.SharedPreferences


/* Create a utility class to manage the SharedPreferences flag:
* This utility class manages the SharedPreferences flag for tracking the first launch.
*/
class AppPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean("is_first_launch", true)
    }

    fun setFirstLaunch(completed: Boolean) {
        sharedPreferences.edit().putBoolean("is_first_launch", completed).apply()
    }
}