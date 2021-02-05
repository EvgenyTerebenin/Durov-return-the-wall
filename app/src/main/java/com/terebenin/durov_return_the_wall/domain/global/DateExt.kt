package com.terebenin.durov_return_the_wall.domain.global

import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

/** Format a time to show day, month, and time, e.g. "7 May 10:00" */
fun ZonedDateTime.toDateTimeString(): String {
    return DateTimeFormatter.ofPattern("d MMM h:mm").format(this)
}