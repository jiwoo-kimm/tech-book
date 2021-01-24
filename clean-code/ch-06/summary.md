# 6장| 객체와 자료 구조

## 💻 자료 추상화

> "변수를 private으로 선언하더라도 각 값마다 getter, setter 함수를 제공한다면 구현을 외부로 노출하는 셈이다.<br>추상 인터페이스를 제공해 사용자가 구현을 모른 채 자료의 핵심을 조작할 수 있어야 진정한 의미의 클래스다." (p.119)

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
* 활성 레코드: 공개, 비공개 변수와 getter, setter, 그리고 탐색 함수가 있는 클래스

## 💻 결론

#### 바람직한 구조
* 객체: 비공개 변수와 공개 함수만 포함
* 자료 구조: 함수 없이 공개 변수만 포함

#### 적합한 쓰임
* 객체: 새로운 자료 타입 추가
* 자료 구조: 새로운 메소드 추가

## 📝 느낀점

여태 코드를 짜면서 private 변수에 getter, setter를 달아 놓는 것이 의문스러웠었는데, 그게 의미없는 잘못된 짓이라는 것을 알게 되었다. 객체는 비즈니스 로직, 즉 '할 일'만 정의하고 나머지 속성들은 숨기는 데에 의미가 있다. 헌데 나는 객체를 만들어 놓고도 절차 지향적 코드를 짰으니 스스로도 자신의 코드에 의문이 생길 수 밖에 없었던 것 같다. 특히, 예시 6-1에 있던 Point 클래스.. 내가 학교에서 배웠던 것, 그리고 내가 써왔던 것과 정확히 일치는 예시였다. interface로 구현된 제대로 된 Point 클래스를 보니 감탄이 절로 나왔고, 나도 저런 코드를 후룩 쓸 수 있는 능력을 갖고 싶어졌다.<br><br>
또한, 객체지향이 무조건 옳다는 편향적인 시각을 가질 것이 아니라, 자료 구조와 객체 둘 다 적절한 쓰임이 있으니 그것을 잘 판단하고 활용해야 한다는 것을 알게 되었다. 이 부분은 솔직히 한 번에 와닿지가 않아서 두어번 정독했다. 결국 자료 구조는 무조건 필드로 바로 접근을 하고, 객체는 메소드로 접근을 하는 게 가장 큰 차이인 것 같다.<br><br>
