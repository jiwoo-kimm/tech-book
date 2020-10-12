# 11장 | 시스템

### 🚩 높은 추상화 수준, 즉 깨끗한 시스템을 유지하는 방법

## 💻 시스템 제작과 시스템 사용을 분리하라

__제작(Construction): 어플리케이션 객체를 제작하고 의존성을 서로 연결하는 과정__<br>
__사용(Use): 제작 과정 이후 이어지는 런타임 과정__

### 관심사(Concern) 분리

가장 흔히 쓰이는 초기화 지연(Lazy Initialization)의 한계
```java
public Service getService() {
  if (service == null)
    service = new MyServiceImpl(...);
  return service;
}
```

- `MyServiceImpl`이 모든 상황에 적절하지 않을 수 있음
- `MyServiceImpl` 생성자 인수에 의존함
- 단위 테스트 시 테스트 전용 `service` 객체를 할당해야 함
- 객체 생성 로직의 모든 실행 경로를 테스트해야 함
- 단일 책임 원칙(SRP)에 반함

> "체계적이고 탄탄한 시스템을 만들고 싶다면 흔히 쓰는 좀스럽고 손쉬운 기법으로 모듈성을 깨서는 절대로 안 된다." (p.196)

### Main 분리

![ch-11-01.png](https://github.com/jiwoo-kimm/clean-code/blob/master/ch-11/ch-11-01.png)

- 생성과 관련한 코드는 모두 main이나 main이 호출하는 모듈로 옮긴다.
- 나머지 시스템은 모든 객체가 생성되었고 모든 의존성이 적절히 연결되었다고 가정하고 객체를 사용한다.

### 팩토리

![ch-11-02.png](https://github.com/jiwoo-kimm/clean-code/blob/master/ch-11/ch-11-02.png)

- 

## 📝 느낀점
