## 💡 Mock 객체를 사용하여 의존성이 있는 다른 코드와 분리하기

의존하는 객체를 Stub과 Mock을 활용하여 테스트 로직과 분리하면, 더 빠른 테스트, 더 간결한 테스트를 작성할 수 있으며, 커버리지가 명확해져 오류 가능성도 줄일 수 있다. 적절한 도구를 사용하여 Mock을 생성하고 주입하면 효율적으로 테스트를 작성할 수 있다.

<br>

## Stub

테스트 용도로 하드 코딩한 값을 반환하는 구현체로, 별다른 설정 없이 원하는 클래스의 Stub 인스턴스를 메소드 안에서 생성하여 메서드 로직을 테스트할 수 있다.

### Stub 인자 검증

객체가 제대로 된 인자를 정확하게 넘기는 지 검증하기 위해, Stub 객체의 인자를 검증하고 조건을 만족시키지 않는 경우 테스트를 fail시킬 수 있다.

하지만 이렇게 모든 조건을 매 테스트마다 체크하는 것보다는, Mock 인스턴스를 생성하고 관리하는 방법이 권장된다.

<br>

## Mock

### Stub에서 Mock으로 변환

Mock 인스턴스는 아래 조건들을 만족시킨다는 점에서 Stub 인스턴스와 차이가 있다.
- 테스트에 어떤 인자를 기대하는지 명시하기
- 메서드에 넘겨진 인자들을 잡아서 저장하기
- 메서드에 저장된 인자들이 기대하는 인자들인지 테스트가 완료될 때 검증하는 능력 지원하기

### Mockito

위와 같은 번거로운 작업은 이미 만들어진 라이브러리가 알아서 다 해준다. 활용방법의 예는 아래와 같다.

```java
Http http = mock(Http.class);
when(http.get(contains("lat=38.000000&lon=-104.000000")))
  .thenReturn(
  	// ...
  );
AddressRetriever retriever = new AddressRetriever(http);
// ...
```

- `mock()`: Mock 인스턴스를 합성
- `when()`: 테스트의 기대 사항 설정
- `thenReturn()`: 기대 사항이 충족되었을 때의 처리

### Mock 주입

위와 같이 생성자에 Mock 객체를 직접 넘기면 클래스 내부 사항을 노출하게 되고, 이는 깔끔한 테스트에 방해가 된다. 따라서 Mockito나 Spring에서 제공하는 DI 도구를 사용하면 생성자 주입 없이 깔끔하게 Mock 객체를 관리할 수 있다.

```java
@Mock private Http http;  // Mock 인스턴스
@InjectMocks private AddressRetriever retriever;  // 주입 대상 인스턴스

@Before
public void createRetriever() {
  retriever = new AddressRetriever();
  MockitoAnnotations.openMocks(this); // `mock(Http.class)`와 동일하게 작동
}
```

- `@Mock`: Mock 인스턴스를 합성하고자 하는 필드
- `@InjectMocks`: 합성한 Mock을 주입하고자 하는 대상 필드
- `MockitoAnnotations.openMocks(this)`
  - `this`: 테스트 클래스 자체
  - 테스트 클래스의 `@Mock` 필드에 대해 모두 인스턴스 합성
  - `@InjectMocks` 필드에 모든 Mock 인스턴스 주입 

### Mock 사용 시 유의점

Mock은 실제 동작을 대신하는 객체이다. 이를 테스트에서 안전하게 사용하고 프로덕션 코드까지 검증하기 위해서 테스트 커버리지의 간극을 형성할 수 있음을 유의해야 한다.

1. 코드의 동작을 분명하게 기술해야 한다.
    - 연관성을 쉽게 파악할 수 있도록 기술해야 한다.
2. 프로덕션 코드를 실행하면 안 된다.
    -  임시로 예외를 던지거나, 프로덕션 코드에서 실패하는 데이터로 테스트하여 검증할 수 있다.
3. Mock으로 인한 테스트 커버리지의 간극(gap)을 통합 테스트로 막아야 한다.
