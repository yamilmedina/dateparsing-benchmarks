package io.github.yamilmedina.dateparser

import io.github.yamilmedina.dateparser.DateParserExt.fullDateShortTimeFormatter
import io.github.yamilmedina.dateparser.DateParserExt.simpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

object DateParserExt {
    val fullDateShortTimeFormatter: DateTimeFormatter = DateTimeFormatter
        .ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    val simpleDateFormat =
        java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

}

fun String.withTextSimpleDateFormat(): Date? {
    return simpleDateFormat.parse(this)
}

fun String.withLocalDateTimeParser(): LocalDateTime? {
    return LocalDateTime.parse(this, fullDateShortTimeFormatter)
}

fun String.withJavaInstantParser(): Instant {
    return Instant.parse(this)
}

fun String.withKotlinInstantParser() {
    kotlinx.datetime.Instant.parse(this)
}