# 2장 | JUnit 진짜로 써 보기

## 기본 Annotation

#### `@Test`
테스트 메소드로 인식하고 테스트를 실행한다.

### `@Disabled`
테스트 메소드로 인식하지 않고 테스트도 실행하지 않는다.

#### `@BeforeEach` vs `@BeforeAll`
||`@BeforeEach`|`@BeforeAll`|
|--|--|--|
|메소드|instance method|static method|
|실행시점|테스트 메소드 실행 전|클래스 인스턴스 생성 시|

#### `@AfterEach` vs `@AfterAll`
||`@AfterEach`|`@AfterAll`|
|--|--|--|
|메소드|instance method|static method|
|실행시점|테스트 메소드 실행 후|인스턴스의 모든 테스트 메소드 실행 후|
