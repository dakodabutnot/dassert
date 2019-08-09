# dassert

### installation
_kotlin DSL_

add jitpack.io to your repositories
```gradle
repositories {
  ...
  maven(url = "https://jitpack.io")
}
```

then add this repo as a dependency
```gradle
dependencies {
  implementation("com.github.dakodabutnot", "dassert", "0.1")
}
```

### usage

full list of examples for all supported assertions

```kotlin
dassert {
  foo.isNull
  bar.isNotNull
  foo.isTrue
  bar.isFalse
  foo isEqualTo bar
  foo isNotEqualTo bar
  foo isSameAs bar
  foo isNotSameAs bar
  foo isIn bar
  foo isNotIn bar
  foo `is` bar
  foo isNot bar
  foo satisfies bar
  foo isInstanceOf bar
  foo isNotInstanceOf bar
  foo hasToString bar
  foo isGreaterThan bar
  foo isLessThan bar
  foo isGreaterThanOrEqualTo bar
  foo isLessThanOrEqualTo bar
  foo doesContain bar
  foo doesntContain bar
}
```
