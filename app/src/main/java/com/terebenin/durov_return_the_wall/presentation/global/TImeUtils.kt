package com.terebenin.durov_return_the_wall.presentation.global

import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

object TImeUtils {
    /** Format a time to show month, day, and time, e.g. "May 7, 10:00 AM" */
    fun dateTimeString(startTime: ZonedDateTime): String {
        return DateTimeFormatter.ofPattern("d MMM h:mm").format(startTime)
    }
}