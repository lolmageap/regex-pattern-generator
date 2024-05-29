# regex-pattern-generator

정규식 패턴을 보다 쉽게 생성해주는 도구입니다.
파악하기 어려운 정규식을 쉽게 이해할 수 있도록 도와줍니다.

## 사용법

### 알파벳과 숫자만을 포함하는 정규식 패턴을 생성
```kotlin
val pattern = Regex.alpabet + Regex.number

require(pattern == "[a-zA-Z0-9]")
```

### 특정 문자열을 포함하는 정규식 패턴을 생성
```kotlin
val pattern = Regex.specialCharacter

require(pattern == "^[!@#$%^&*()_+\-=\[\]{};':\"\\|,.<>\/?]*$")
```

### 특정 특수 문자를 제외하는 정규식 패턴을 생성
```kotlin
val pattern = Regex.specialCharacter.exclude("!#@")

require(pattern == "^[$%^&*()_+\-=\[\]{};':\"\\|,.<>\/?]*$")
```

### 알파벳과 숫자, 특정 특수 문자를 제외한 특수 문자를 포함 하는 정규식 패턴을 생성
```kotlin
val pattern = Regex.alpabet + Regex.number + Regex.specialCharacter.exclude("!#@")

val expected = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[%^&*()_+\-=\[\]{};':\"\\|,.<>\?]*).*$"
require(pattern == expected)
```

### 알파벳에 특정 특수 문자를 허용하도록 정규식 패턴을 생성
```kotlin
val pattern = Regex.alpabet.include("!@#")
```

### 문자열의 길이를 제한하는 정규식 패턴을 생성
```kotlin
val pattern = Regex.length(5, 10)
```

### 문자열의 최소 길이를 제한하는 정규식 패턴을 생성
```kotlin
val pattern = Regex.min(5)
```

### 문자열의 최대 길이를 제한하는 정규식 패턴을 생성
```kotlin
val pattern = Regex.max(10)
```