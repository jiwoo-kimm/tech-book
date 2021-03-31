# 제 10장 | 목 객체 사용

💡 Mock 객체를 사용하여 의존성이 있는 다른 코드(API)와 분리하기

<br>

## Stub
- 테스트 용도로 하드 코딩한 값을 반환하는 구현체
- 별다른 설정 없이 stub 인스턴스를 생성하여 메서드 로직 테스트

### Stub 인자 검증
- 객체가 제대로 된 인자를 정확하게 넘기는 지 검증

<br>

## Mock

### Stub에서 Mock으로 변환
- 테스트에 어떤 인자를 기대하는지 명시하기
- 메서드에 넘겨진 인자들을 잡아서 저장하기
- 메서드에 저장된 인자들이 기대하는 인자들인지 테스트가 완료될 때 검증하는 능력 지원하기

### Mockito
번거로운 작업은 이미 만들어진 라이브러리에 맡기자

```java
Http http = mock(Http.class);
when(http.get(contains("lat=38.000000&lon=-104.000000")))
  .thenReturn(
      ...
  );
```

- `mock()`: Mock 인스턴스를 합성
- `when()`: 테스트의 기대 사항 설정
- `thenReturn()`: 기대 사항이 충족되었을 때의 처리

### Mock 주입
- 생성자에 Mock 객체를 직접 넘기면 내부 사항을 노출하게 됨
- DI 도구를 사용하자

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
