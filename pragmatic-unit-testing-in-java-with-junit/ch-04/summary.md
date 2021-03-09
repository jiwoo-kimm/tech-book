# 4장 | 테스트 조직

<br>

## AAA

1. Arrange | 준비
    - 테스트 코드를 실행하기 전 시스템의 상태를 확인
2. Act | 실행
    - 테스트 실행 (보통 단일 메소드 호출)
3. Assert | 단언
    - 실행한 코드가 기대한 대로 동작하는지 확인
4. After | 사후
    - 자원 할당이 잘 정리되었는지 확인
 
## 의미있는 테스트

- 일관성 있고 의미 있는 테스트 이름 도입<br>
ex) `doingSomeOperationGeneratesSomeResult`, `someResultOccursUnderSomeCondition`, `whenDoingSomeBehaviorThenSomeResultOccurs`
- 지역 변수 이름 개선
- 의미 있는 상수 도입
- hamcrest 단언 사용
- 작고 집중적인 테스트로 개선
- 도우미 메소드와 @Before 메소드 활용
