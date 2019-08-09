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

#### boolean checking

```kotlin
val foo = true
dassert {
  foo.isTrue // true
  foo.isFalse // false
}
```

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

#### comparison

```kotlin
val foo = 2; val bar = 6
dassert {
  foo isGreaterThan bar // false
  foo isLessThan bar // true
}
```

```kotlin
val foo = 2; val bar = 2
dassert {
  foo isGreaterThan bar // false
  foo isGreaterThanOrEqualTo bar // true
}
```

#### collections

_lists, sets and arrays_

```kotlin
val foo = "someString"
val bar = arrayOf(foo, "anotherString", "1")
dassert {
  foo doesContain bar // true
  foo doesntContain bar // false
}
```
