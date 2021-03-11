# 6장 | Right-BICEP
무엇을 테스트하는 것이 중요한가?

<br>

### Right
결과가 올바른가?

- 기대한 결과를 산출하는지 검증할 수 있어야 한다.

<br>

### Boundary Conditions
경계 조건은 맞는가?

- 결함을 일으키는 corner cases를 처리해야 한다.<br>
ex) 수치적 오버플로우, 비거나 빠진 값, 중복값 등
- [CORRECT](https://github.com/jiwoo-kimm/tech-book/tree/master/pragmatic-unit-testing-in-java-with-junit/ch-07/summary.md)

<br>

### Inverse Relationship
역 관계를 검사할 수 있는가?

- 논리적인 역 관계로 기능을 검증할 수 있다.
- 교차 검사로 기능을 검증할 수 있다.

<br>

### Cross-Check
다른 수단을 활용하여 교차 검사할 수 있는가?

- 무수한 해법 중 직접 사용되지 않는 다른 방법을 통해 값을 검증할 수 있다.
- 클래스의 서로 다른 조각 데이터를 사용하여 모든 데이터가 합산되는지 확인할 수 있다.

<br>

### Error Conditions
오류 조건을 강제로 일어나게 할 수 있는가?

- 모든 실전 문제들을 다루기 위해 테스트에서 오류들을 강제로 발생시킬 수 있어야 한다.
- 코드에 존재하는 로직 커버리지 외에도 오류들을 예상해야 한다.

<br>
  
### Performance Characteristics
성능 조건은 기준에 부합하는가?

- 단위 성능 측정과 최적화는 추측이 아닌 실제 데이터을 바탕으로 이루어져야 한다.
- 절대적인 숫자보다는 상대적인 개선량을 통해 최적화를 해야 한다.
