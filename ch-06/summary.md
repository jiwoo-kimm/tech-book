# 6장| 객체와 자료 구조

## 💻 자료 추상화

> "변수를 private으로 선언하더라도 각 값마다 getter, setter 함수를 제공한다면 구현을 외부로 노출하는 셈이다...<br>추상 인터페이스를 제공해 사용자가 구현을 모른 채 자료의 핵심을 조작할 수 있어야 진정한 의미의 클래스다." (p.119)

* 구체적인 Point 클래스
```java
@Getter
@Setter
public class Point {
  private double x;
  private double y;
}
```

* 추상적인 Point 클래스
```java
public interface Point {
  double getX();
  double getY();
  void setCatesian(double x, double y);
  double getR();
  double getTheta();
  void setPolar(double r, double theta);
}
```

* 구체적인 Vehicle 클래스
```java
public interface Vehicle {
  double getFuelTankCapacityInGallons();
  double getGallonsOfGasoline();
}
```

* 추상적인 Vehicle 클래스
```java
public interface Vehicle {
  double getPercentFuelRemaining();
}
```

#### 진짜 추상적인 클래스 특징
- 자료를 공개하지 않고 추상적인 개념으로 표현
- 클래스 메소드가 접근 정책을 강제
- 구현을 감추면서도 조작 가능

## 💻 자료/객체 비대칭
클래스 기반 코드와 자료 구조 기반 코드는 적절한 쓰임새가 다름
* 클래스: 새로운 자료 타입을 추가하는 경우
* 자료 구조: 새로운 메소드를 추가하는 경우

## 💻 디미터 법칙
객체는 조회 함수로 내부 구조를 공개하면 안된다.

#### 기차 충돌

```java
String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
```
→ 메소드가 반환하는 객체의 메소드를 사용해서 디미터 법칙 위반<br>
→ 아래 코드로 변환하는 것이 바람직함

```java
Options opts = ctxt.getOptions();
File scratchDir = opts.getScratchDir();
String outputDir = scratchDir.getAbsolutePath();
```
→ ctxt, opts, scratchDir이 객체면 디미터 법칙 위반<br>
→ ctxt, opts, scratchDir이 자료 구조면 디미터 법칙 적용 X<br>

#### 잡종 구조
* 공개 변수, 공개 함수, 주요 함수, getter, setter 모두 섞여 있는 구조
* 클래스, 자료 구조 양쪽에서 단점만 모아 놓은 피해야 할 구조

#### 구조체 감추기
```java
BufferedOutputStream bos = ctxt.createScratchFileStream(classFileName);
```
→ 디렉토리 경로를 얻는 목적은 임시 파일 생성을 위함
→ ctxt 객체가 최종 목적인 임시 파일을 생성하도록 명령하면 됨

## 💻 자료 전달 객체

* DTO: 공개 변수만 있고 함수가 없는 클래스
* Bean: 비공개 변수와 getter, setter가 있는 클래스
* 활성 케로드: 공개, 비공개 변수와 getter, setter, 그리고 탐색 함수가 있는 클래스

## 💻 결론

#### 바람직한 구조
* 객체: 비공개 변수와 공개 함수만 포함
* 자료 구조: 함수 없이 공개 변수만 포함

#### 적합한 쓰임
* 객체: 새로운 자료 타입 추가
* 자료 구조: 새로운 동작 추가

