# 7장 | 경계조건: CORRECT
경계조건들에 관계된 결함들

<br>

### Conformance | 준수
- 데이터 요소가 특정 양식을 따르는가?
- 시스템의 데이터 흐름을 이해하여 적절한 때에 양식 준수 조건을 검증하면 불필요한 테스트를 줄일 수 있다.
 
<br>
 
### Ordering | 순서
- 데이터 순서나 컬렉션 내 데이터의 위치가 올바른가?

<br>

### Range | 범위
- 데이터 값의 범위가 유효한가?
- 자바 기본형으로 변수를 만들기보다는 추상화된 클래스를 만들고, 생성자에서 검증하는 것이 바람직하다.
- `@After` 메소드의 단언식을 통해 불변식을 항상 검증할 수 있다.
  - `TypeSafeMatcher`를 구현한 Custom Matcher
  - 불변 메소드를 내장해서 호출
- 인덱싱의 잠재적인 오류를 미리 파악하고 처리해야 한다.

<br>

### Reference | 참조
- 참조에 의존한다면 그 참조가 유효한가?
- 참조가 유효하지 않아도 코드가 합리적으로 작동해야 한다.
- 사전·사후 조건, 그리고 side affects를 검사해야 한다.

<br>

### Existence | 존재
- 데이터가 없을 때 발생하는 불행 경로를 놓치지 않는가?
- 문제 원인을 쉽게 파악하기 위해 미리 검사하고 처리해야 한다.

<br>

### Cardinality | 기수
- 기수에 따른 케이스를 모두 커버하는가?
- 0-1-n 법칙에 따라 테스트 케이스를 집중해서 작성해야 한다.

<br>

### Time | 시간
- 상대적 시간: 메소드 호출 순서, 자원 할당 순서가 맞지 않은 경우를 모두 커버해야 한다.
- 절대적 시간: 시간은 언제나 절대적이지 않고 상대적이므로 변동성을 고려해야 한다.
- 동시성 문제: 다수의 스레드, 인스턴스 수준, 외적인 접근 등을 모두 커버해야 한다.