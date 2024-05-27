# regex-pattern-generator

정규식 패턴을 보다 쉽게 생성해주는 도구입니다.
파악하기 어려운 정규식을 쉽게 이해할 수 있도록 도와줍니다.

## 사용법

### 알파벳과 숫자만을 포함하는 정규식 패턴을 생성
```kotlin
val pattern = RegexPatternGenerator.alpabet + RegexPatternGenerator.number

require(pattern == "[a-zA-Z0-9]")
```

### 특정 문자열을 포함하는 정규식 패턴을 생성
```kotlin
val pattern = RegexPatternGenerator.specialCharacter

require(pattern == "^[!@#$%^&*()_+\-=\[\]{};':\"\\|,.<>\/?]*$")
```

### 특정 특수 문자를 제외하는 정규식 패턴을 생성
```kotlin
val pattern = RegexPatternGenerator.specialCharacter.exclude("!#@")

require(pattern == "^[$%^&*()_+\-=\[\]{};':\"\\|,.<>\/?]*$")
```