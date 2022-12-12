package jh.openweather.app.utils

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavController.navigateSafe(
    navAction: NavDirections
) {
    val action = currentDestination?.getAction(navAction.actionId) ?: graph.getAction(navAction.actionId)
    // 현재 fragment 의 id와 이동할 fragment 의 id가 다르면 화면이동 실행 (같다는 건, 이미 이동이 된 후이기 때문)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(navAction.actionId, navAction.arguments, null, null)
    }
}

// 현재 디바이스 다크테마 확인
fun Context.isNightMode() : Boolean {
    val result = when(AppCompatDelegate.getDefaultNightMode()) {
        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM, AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY -> { // System Setting Theme
            this.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        }
        AppCompatDelegate.MODE_NIGHT_NO -> {
            false
        }
        AppCompatDelegate.MODE_NIGHT_YES -> {
            true
        }
        else -> false
    }

    return result
}