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

#### null-checking

```kotlin
val foo = null
dassert {
  foo.isNull // true
  foo.isNotNull // false
}
```

#### equality

```kotlin
val foo = "foo"; val bar = "bar"
dassert {
  foo isEqualTo bar // false
  foo isEqualTo foo // true
  foo isNotEqualTo bar // true
}
```

```kotlin
dassert {
  foo.isTrue
  bar.isFalse
  foo isSameAs bar
  foo isNotSameAs bar
  foo isIn bar
  foo isNotIn bar
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
