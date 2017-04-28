[![JitPack](https://img.shields.io/github/tag/yongjhih/kxdate.svg?label=JitPack)](https://jitpack.io/#yongjhih/kxdate)
[![javadoc](https://img.shields.io/github/tag/yongjhih/kxdate.svg?label=javadoc)](https://jitpack.io/com/github/yongjhih/kxdate/kxdate/-SNAPSHOT/javadoc/)
[![Build Status](https://travis-ci.org/yongjhih/kxdate.svg)](https://travis-ci.org/yongjhih/kxdate)
<!--[![Coverage Status](https://coveralls.io/repos/github/yongjhih/kxdate/badge.svg?branch=master)](https://coveralls.io/github/yongjhih/kxdate?branch=master)-->
<!--[![Codacy Badge](https://api.codacy.com/project/badge/Grade/64490a4beab54dcaa8f5b23022d607d5)](https://www.codacy.com/app/yongjhih/kxdate)-->

# kxdate

This library contains various Kotlin extensions for the [Java 8 java.time API](https://docs.oracle.com/javase/tutorial/datetime/iso/index.html).

## Usage - Rails Style Date Constants

kxdate supports the [Rails-style](http://guides.rubyonrails.org/active_support_core_extensions.html#time) syntax for defining date constants:

Before:

```kt
val threeSecondsLater = LocalDateTime.now() + Duration.ofSeconds(3L) // or LocalDateTime.now().plusSeconds(3L)
val twoMonthsLater    = LocalDate.now() + Period.ofMonths(2L) // or LocalDate.now().plusMonths(2L)
val yesterday = LocalDate.now() + Period.ofDays(-1L) // or LocalDate.now().minusDays(1L)
val fourAndFiveYearsAgo = LocalDate.now() + Period.ofMonths(-4L) + Period.ofYears(-5L) // or LocalDate.now().minusMonths(4L).minusYears(5L)

val threeSecondsLaterDate = DateTimeUtils.toDate((LocalDateTime.now() + Duration.ofSeconds(3L)).atZone(ZoneId.systemDefault()).toInstant())
val nowEpochSeconds = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().epochSecond
```

After:

```kt
val threeSecondsLater = 3.seconds.later
val twoMonthsLater = 2.months.later
val yesterday = 1.days.ago
val fourAndFiveYearsAgo = (4.months + 5.years).later

val threeSecondsLaterDate = 3.seconds.later.toDate()
val nowEpochSeconds = LocalDateTime.now().toEpochSecond()
```

Alternatively, you can use the infix call syntax:

```
val threeSecondsLater = 3 seconds later
val twoMonthsLater = 2 months later
val yesterday = 1 days ago
```

## Installation

via jitpack.io

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih.kxdate:kxdate:-SNAPSHOT'
}
```

For Java7 backport:

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih.kxdate:kxdate-threetenbp:-SNAPSHOT'
}
```

For android

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih.kxdate:kxdate-threetenbp-android:-SNAPSHOT'
}
```

In Application:

```kt
override fun onCreate() {
  super.onCreate()

  AndroidThreeTen.init(this)
}
```
