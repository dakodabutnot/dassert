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
  implementation("com.github.dakodabutnot", "dassert", "1.0.1")
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

#### maps

```kotlin
val someMap = mutableMapOf("foo" to 1, "bar" to 9)
dassert {
  map(someMap) {
    "foo" maps 1
    "bar" maps 9
    "foobar" maps 19
  }
}
```

Map assertions can fail in two ways. Either the key doesn't exist in the supplied map, or the value expected is wrong. In the case of the above example:

`Exception in thread "main" java.lang.RuntimeException: Error during assertion. The key [foobar] does not exist in the supplied map.`

If the example was changed to be:

```kotlin
"foo" maps 1 // true
"bar" maps 8 // false
```

then the following exception would then be thrown:

`Exception in thread "main" java.lang.RuntimeException: Error during assertion. At key [bar], expected value to be 8 (java.lang.Integer@694f9431) but was 9 (java.lang.Integer@f2a0b8e).`
