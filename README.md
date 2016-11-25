[![JitPack](https://img.shields.io/github/tag/yongjhih/kxdate.svg?label=JitPack)](https://jitpack.io/#yongjhih/kxdate)
[![javadoc](https://img.shields.io/github/tag/yongjhih/kxdate.svg?label=javadoc)](https://jitpack.io/com/github/yongjhih/kxdate/kxdate/-SNAPSHOT/javadoc/)
[![Build Status](https://travis-ci.org/yongjhih/kxdate.svg)](https://travis-ci.org/yongjhih/kxdate)
<!--[![Coverage Status](https://coveralls.io/repos/github/yongjhih/kxdate/badge.svg?branch=master)](https://coveralls.io/github/yongjhih/kxdate?branch=master)-->
<!--[![Codacy Badge](https://api.codacy.com/project/badge/Grade/64490a4beab54dcaa8f5b23022d607d5)](https://www.codacy.com/app/yongjhih/kxdate)-->

# kxdate

This library contains various Kotlin extensions for the [Java 8 java.time API](https://docs.oracle.com/javase/tutorial/datetime/iso/index.html).

## Usage - Rails Style Date Constants

kxdate supports the [Rails-style](http://guides.rubyonrails.org/active_support_core_extensions.html#time) syntax for defining date constants:

```
val twoMonthsLater = 2.months.fromNow

val yesterday = 1.days.ago

(4.months + 5.years).fromNow
```

Alternatively, you can use the infix call syntax:

```
val twoMonthsLater = 2 months fromNow
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
