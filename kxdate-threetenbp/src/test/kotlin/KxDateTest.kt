package ru.yole.kxdate

import kxdate.threeten.bp.*
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDate.now

import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.threeten.bp.Period

class KxDateSpec: Spek ({
    describe("KxDate Spec") {

        it ("oneDayAgo") {
            val x = 1.days.ago
            LocalDate.now().minusDays(1) `should equal` x
        }


        it ("oneDayAgoInfix") {
            val x = 1 days ago
            LocalDate.now().minusDays(1) `should equal` x
        }


        it ("oneWeekFromNow") {
            val x = 1.weeks.fromNow
            LocalDate.now().plusDays(7) `should equal` x
        }


        it ("oneMonthFromNow") {
            val x = 1.months.fromNow
            LocalDate.now().plusMonths(1) `should equal` x
        }


        it ("addDurations") {
            val x = (4.months + 5.years).fromNow
            LocalDate.now().plusMonths(4).plusYears(5) `should equal` x
        }


        it ("oneHourFromNow") {
            val x = 1.hours.fromNow
            //LocalDateTime.now().plusHours(1).truncatedTo(ChronoUnit.HOURS) `should equal`  x.truncatedTo(ChronoUnit.HOURS))
        }


        it ("duringAge") {
            "1984-11-19".during(now()).years `should equal` Period.between(LocalDate.parse("1984-11-19"), LocalDate.now()).years
        }

        it ("duringNowAge") {
            // NOTICE race condition of now
            "1984-11-19".duringNow.years `should equal` Period.between(LocalDate.parse("1984-11-19"), now()).years
        }

        it ("duringAgeInfix") {
            ("1984-11-19" during "2016-11-19").years `should equal` Period.between(LocalDate.parse("1984-11-19"), LocalDate.parse("2016-11-19")).years
        }
    }
})


