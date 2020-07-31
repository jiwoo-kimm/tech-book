# 2장 | 의미 있는 이름


## 💻 의도를 분명히 밝혀라

#### 맥락이 코드 자체에 명시적으로 드러나도록 이름에 정보를 함축하라.

* 나쁜 예
```java
int d;  // 경과 시간(단위: 날짜)
```

* 좋은 예
```java
int elapsedTimeInDays;
int daysSinceCreation;
int daysSinceModification;
int fileAgeInDays;
```

## 💻 그릇된 정보를 피하라

#### 코드의 의미를 흐리지 않도록 하라.

* 널리 쓰이는 의미가 있는 단어를 사용하지 마라<br>
ex) `hp`, `aix`, `sco`

* 그룹 변수 이름에 List를 사용하지 마라<br>
ex) `accountList` → `accountGroup`, `accounts`

* 서로 유사한 이름을 사용하지 마라<br>
ex) `XYZController`, `ForEfficientHandling`, `XYZControllerForEfficientHandling`


## 💻 의미 있게 구분하라

#### 읽는 사람이 차이를 알도록 이름을 지어라.

* 연속된 숫자로 이름을 구분하지 마라<br>
ex) `copyChars(char a1[], char a2[])` → `copyChars(char source[], char destination[])`

* 불용어로 이름을 구분하지 마라<br>
ex) `Product` | `ProductInfo`, `ProductData`, `theProduct`, `aProduct`, `Products`<br>
ex) `SomethingManager` | `SomethingProcessor`


## 💻 발음하기 쉬운 이름을 사용하라

#### 이미 알고 있는 단어를 효율적으로 활용하라.<br><br>


## 💻 검색하기 쉬운 이름을 사용하라

#### 사용 위치를 쉽게 확인할 수 있는 의미있는 이름을 지어라.<br><br>


## 💻 인코딩을 피하라

#### 이름에 불필요한 정보를 추가하지 말고 IDE를 활용하라.

* 헝가리식 표기법: 타입을 변수명에 명시하지 마라
* 멤버 변수 접두어 `m_`: 이름을 다르게 하지 않아도 멤버 변수임을 확인할 수 있어야 한다
* 인터페이스 클래스와 구현 클래스: 예외로, 구체 클래스(concrete class)에 `Impl` 접미어 인코딩은 필요하다


## 💻 자신의 기억력을 자랑하지 마라

#### 남들이 이해할 수 있고 변경하지 않아도 되는 이름을 사용하라.<br><br>


## 💻 클래스 이름

#### 클래스, 객체 이름은 명사나 명사구가 적합하다.<br><br>


## 💻 메소드 이름

#### 메소드 이름은 동사나 동사구가 적합하다.

* 좋은 예
```java
String name = employee.getName();
customer.setName("jiwoo");
if (paycheck.isPosted())...
```

#### 생성자를 중복정의(overload)할 때는 `정적 팩토리 메소드`를 사용한다.<br><br>


## 💻 기발한 이름은 피하라

#### 재미난 이름보다 명료하고 분명한 이름을 선택하라.


## 📝 느낀점
