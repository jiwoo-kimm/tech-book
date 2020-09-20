# 7장 | 오류 처리

## 💻 오류 코드보다 예외를 사용하라

* 논리 코드와 오류 코드를 분리하라
* 각 개념을 독립적으로 살펴보고 이해할 수 있도록 하라

## 💻 Try-Catch-Finally 문부터 작성하라

* 강제로 예외를 일으키는 테스트 케이스를 작성한 후 테스트를 통과하게 하는 코드를 작성하라
```java
public List<RecordedGrip> retrieveSection(String sectionName) {
  try{
    FileInputStream stream = new FileInputStream(sectionName);
    stream.close();
  } catch (FileNotFoundException e) {
    throw new StorageException("retrieval error", e);
  }
  return new ArrayList<RecordedGrip>();
}
```

## 💻 Unchecked exception을 사용하라

* Checked Exception은 선언부의 수정을 필요로 하기 때문에 모듈의 캡슐화를 깨버린다

||Checked Exception|UnChecked Exception|
|--|--|--|
|확인 시점|컴파일 시점|런타임 시점|
|처리 여부|반드시 처리|명시적으로 처리하지 않아도 됨|
|트랜잭션 처리|roll-back 하지 않음|roll-back 함|
|예|IOException, ClassNotFoundException|NullPointerException, ArithmeticException|

## 💻 예외에 의미를 제공하라

* 호출 스택으로는 오류에 대한 정보가 부족하다
* 오류 메세지 정보(연산 이름, 실패 유형 등)를 충분히 추가한다

## 💻 호출자를 고려해 예외 클래스를 정의하라

* 가장 중요한 것은 오류를 잡아내는 방법
* 외부 API를 사용할 때는 Wrapper 기법 사죵
  - 외부 라이브러리와 프로그램 간 의존성이 크게 줄어듦
  - 다른 라이브러리로 변경할 때 비용이 줄어듦
  - Wrapper 클래스 내부에 테스트코드 작성 가능
  - 기존 API 설계 방식에 귀속되지 않음

```java
LocalPort port = new LocalPort(12);
try {
  port.open();
} catch (PortDeviceFailure e) {
  reportError(e);
  logger.log(e.getMessage(), e);
} finally {
  ...
}
```
```java
public class LocalPort {
  private ACMEPort innerPort;
  
  public LocalPort(int portNumber) {
    innerPort = new ACMEPort(portNumber);
  }
  
  public void open() {
    try{
      innerPort.open();
    } catch (DeviceResponseException e) {
      throw new PortDeviceFailure(e);
    } catch (ATM1212UnlockedException e) {
      throw new PortDeviceFailure(e);
    } catch (GMXError e) {
      throw new PortDeviceFailure(e);
    }
  }
  
  ...
}
```

## 💻 정상 흐름을 정의하라

* 특수 상황을 예외로 처리하면 논리를 따라가기 어렵다
* Special Case Pattern(특수 사례 패턴)
  - 클래스를 만들거나 객체를 조작해 특수 사례를 처리한다
  - 클래스나 객체가 예외적인 상황을 캡슐화하여 처리한다

## 💻 null을 반환하지 마라

* null을 반환하고 이를 `if(object != null)`으로 확인하는 방식은 나쁘다
* null 대신 예외를 던지거나 특수 사례 객체(ex. `Collections.emptyList()`)를 반환하라

## 💻 null을 전달하지 마라

* 예외를 던지거나 assert 문을 사용할 수는 있다
* 하지만 애초에 null을 전달하는 경우는 금지하는 것이 바람직하다
