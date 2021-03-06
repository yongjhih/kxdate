package kxdate.threeten.bp

import org.threeten.bp.Duration
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.Period
import org.threeten.bp.LocalDate.now
import org.threeten.bp.DateTimeUtils
import org.threeten.bp.ZoneId
import java.util.Date

object ago

object later

val Int.nanoseconds: Duration
    get() = Duration.ofNanos(toLong())

val Int.microseconds: Duration
    get() = Duration.ofNanos(toLong() * 1000L)

val Int.milliseconds: Duration
    get() = Duration.ofMillis(toLong())

val Int.seconds: Duration
    get() = Duration.ofSeconds(toLong())

val Int.minutes: Duration
    get() = Duration.ofMinutes(toLong())

val Int.hours: Duration
    get() = Duration.ofHours(toLong())

val Int.days: Period
    get() = Period.ofDays(this)

val Int.weeks: Period
    get() = Period.ofWeeks(this)

val Int.months: Period
    get() = Period.ofMonths(this)

val Int.years: Period
    get() = Period.ofYears(this)

val Duration.ago: LocalDateTime
    get() =  baseTime() - this

val Duration.later: LocalDateTime
    get() =  baseTime() + this

val Period.ago: LocalDate
    get() = baseDate() - this

val Period.later: LocalDate
    get() = baseDate() + this

val String.duringNow: Period
    get() = this.during(now())

infix fun String.during(from: LocalDate) = LocalDate.parse(this).during(from)
infix fun LocalDate.during(from: LocalDate) = Period.between(this, from)
infix fun String.during(from: String) = LocalDate.parse(this) during LocalDate.parse(from)
infix fun LocalDate.during(from: String) = during(LocalDate.parse(from))

infix fun Int.nanoseconds(later: later) = baseTime().plusNanos(toLong())

infix fun Int.nanoseconds(ago: ago) = baseTime().minusNanos(toLong())

infix fun Int.microseconds(later: later) = baseTime().plusNanos(1000L * toLong())

infix fun Int.microseconds(ago: ago) = baseTime().minusNanos(1000L * toLong())

infix fun Int.milliseconds(later: later) = baseTime().plusNanos(1000000L * toLong())

infix fun Int.milliseconds(ago: ago) = baseTime().minusNanos(1000000L * toLong())

infix fun Int.seconds(later: later) = baseTime().plusSeconds(toLong())

infix fun Int.seconds(ago: ago) = baseTime().minusSeconds(toLong())

infix fun Int.minutes(later: later) = baseTime().plusMinutes(toLong())

infix fun Int.minutes(ago: ago) = baseTime().minusMinutes(toLong())

infix fun Int.hours(later: later) = baseTime().plusHours(toLong())

infix fun Int.hours(ago: ago) = baseTime().minusHours(toLong())

infix fun Int.days(later: later) = baseDate().plusDays(toLong())

infix fun Int.days(ago: ago) = baseDate().minusDays(toLong())

infix fun Int.weeks(later: later) = baseDate().plusWeeks(toLong())

infix fun Int.weeks(ago: ago) = baseDate().minusWeeks(toLong())

infix fun Int.months(later: later) = baseDate().plusMonths(toLong())

infix fun Int.months(ago: ago) = baseDate().minusMonths(toLong())

infix fun Int.years(later: later) = baseDate().plusYears(toLong())

infix fun Int.years(ago: ago) = baseDate().minusYears(toLong())

private fun baseDate() = LocalDate.now()

private fun baseTime() = LocalDateTime.now()

fun Date.toLocalDateTime() =
        DateTimeUtils.toInstant(this).atZone(ZoneId.systemDefault()).toLocalDateTime()

fun LocalDateTime.toDate() =
        DateTimeUtils.toDate(this.atZone(ZoneId.systemDefault()).toInstant())

//val LocalDateTime.epochSecond: Long
fun LocalDateTime.toEpochSecond() = this.atZone(ZoneId.systemDefault()).toInstant().epochSecond
