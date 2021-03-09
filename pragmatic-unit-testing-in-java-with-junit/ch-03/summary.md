# 3장 | JUnit 단언 깊게 파기

## Hamcrest

### 기능
- 객체 타입을 검사할 수 있다.
- 두 객체의 참조가 같은 인스턴스인지 검사할 수 있다.
- 다수의 matcher를 결합하여 둘 다 혹은 둘 중에 어떤 것이든 성공하는지 검사할 수 있다.
- 어떤 컬렉션이 요소를 포함하거나 조건에 부합하는지 검사할 수 있다.
- 어떤 컬렉션이 아이템 몇 개를 모두 포함하는지 검사할 수 있다.
- 어떤 컬렉션에 있는 모든 요소가 matcher를 준수하는지 검사할 수 있다.

→ JUnit5 기본 Assertion 클래스에서 제공하는 것보다 유용해서 보다 가독성높은 테스트를 작성할 수 있다.

## Exception

### Test Annotation
- `@Test(expected=SomeException.class)`
- 예외 발생하지 않으면 `java.lang.AssertionError` 발생하고 test fail
- 발생한 예외의 상태를 확인하기 번거로움

### ExpectedException Rule
```java
@Rule
public ExpectedException thrown = ExpectedException.none();

@Test
public void exceptionRule() {
	thrown.expect(InsufficientFundsException.class);
	thrown.expectMessage("balance only 0");
	account.withdraw(100);
}
```
- test 셋업 단계에서 나머지 테스트를 실행할 때 발생할 수 있는 일을 rule에 명시
- rule 기대사항을 예외 객체가 모두 만족시키지 못하면 test fail
