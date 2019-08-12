# dassert

[![](https://jitpack.io/v/dakodabutnot/dassert.svg)](https://jitpack.io/#dakodabutnot/dassert)

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
  implementation("com.github.dakodabutnot", "dassert", "0.3")
}
```

### usage

full list of examples for all supported assertions

#### boolean checking

```.isTrue, .isFalse```

```kotlin
val foo = true
dassert {
  foo.isTrue // true
  foo.isFalse // false
}
```

#### null-checking

```.isNull, .isNotNull```

```kotlin
val foo = null
dassert {
  foo.isNull // true
  foo.isNotNull // false
}
```

#### equality

```equals, noEquals, isZero, isNotZero```

```kotlin
val foo = "foo"; val bar = "bar"
dassert {
  foo equals bar // false
  foo equals foo // true
  foo noEquals bar // true
}
```

#### comparison

```greaterThan, lessThan, greaterThanOrEquals, lessThanOrEquals, notGreaterThan, notLessThan```

```kotlin
val foo = 2; val bar = 6
dassert {
  foo greaterThan bar // false
  foo lessThan bar // true
}
```

```kotlin
val foo = 2; val bar = 2
dassert {
  foo greaterThan bar // false
  foo greaterThanOrEquals bar // true
}
```

#### collections

_maps_

```hasKey, doesntHaveKey, hasValue, doesntHaveValue, containsKey, doesntContainKey, containsValue, doesntContainValue```

```kotlin
val key = "foo"; val value = 5
val map = mapOf(Pair(key, value))
dassert {
  map hasKey "foo" // true
  map hasValue 5 // true
  
  map hasKey "bar" // false
  map hasValue 0 // false
}
```

_lists, sets and arrays_

```has, doesntHave, contains, doesntContain```

```kotlin
val foo = "someString"
val bar = arrayOf(foo, "anotherString", "1")
dassert {
  foo has bar // true
  foo doesntHave bar // false
  
  bar inside foo // true
  bar notInside foo // false
}
```
