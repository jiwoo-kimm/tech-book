# 9장 | 단위 테스트

## 💻 TDD 법칙 세 가지

1. 실패하는 단위 테스트를 작성할 때까지 실제 코드를 작성하지 않는다.
2. 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다.
3. 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.

## 💻 깨끗한 테스트 코드 유지하기

* '지저분해도 빨리' 작성한 테스트 코드는 결국 오히려 테스트를 안하느니 못한 결과를 내놓는다.
* 테스트 코드는 실제 코드 못지 않게 중요하다. 실제 코드 못지 않게 깨끗하게 짜야 한다.
* 테스트는 유연성, 유지보수성, 재사용성을 제공한다.
* 테스트 케이스가 있으면 잠정적인 버그가 없을 것이라는 확신 하에 코드를 변경할 수 있다.

## 💻 깨끗한 테스트 코드 (Feat. 가독성)

* 잡다한 내용은 없애고 `BUILD-OPERATE-CHECK` 패턴을 적용하라.
* 테스트 자료를 만들고, 테스트 자료를 조작한 후, 조작한 결과를 확인하라.

#### 도메인에 특화된 테스트 언어
* API 위에 함수와 유틸리티를 구현한 후, 이를 사용하여 테스트 코드를 작성하라.

#### 이중 표준
* 한정된 자원이라는 테스트 환경 특성 상, 실제 환경에서 사용할 수 없는 방식을 사용하여 가독성을 높여라.

#### 테스트 당 assert 하나
* assert 문이 단 하나인 함수는 결론이 하나라서 코드를 이해하기 쉽고 빠르다.
* assert 문들을 각각의 함수로 분리했을 때 손해가 이득보다 더 크다면, 갯수를 최소화하는 선에서 함수 하나에 여러 assert 문을 넣는 것도 좋다.

#### 테스트 당 개념 하나
* 테스트 함수마다 한 개념만 테스트하라.
* 독자적인 개념은 별도의 테스트 함수로 분리하라.

## 💻 F.I.R.S.T

#### Fast
* 테스트는 빠르게 돌아야 한다.

#### Independent
* 각 테스트는 독립적으로 그리고 어떤 순서로 실행해도 괜찮아야 한다.

#### Repeatable
* 테스트는 어떤 환경에서도 반복 가능해야 한다.

#### Self-Validating
* 테스트는 추가 작업을 요구하지 않고 bool 값으로 결과를 내야 한다.

#### Timely
* 테스트는 적시에 작성해야 한다.

## 📝 느낀점

사실 프로그램을 짜면서 테스트 코드를 작성한 적이 한 번도 없다. 이런 내 자신이 부끄러워지는 챕터였다. 테스트 케이스를 어디부터 어디까지 어떤 수준으로 짜야하는 지 본 적이 없으니 그냥 막막하고 귀찮아서 시도하지 않았던 것인데, 이번 챕터를 통해 약간의 예시를 읽으며 자신감을 조금 얻었다. 테스트 코드는 아주 작은 모듈부터 시작해서 최대한 넓은 범위를 모두 커버할 수 있도록 아주아주 많이 짜야 하는 것이고, 나중에 몰아서 한 번에 하는 것이 아니라 실제 코드를 구현하기 전에 말 그대로 테스트를 하는 것이다. 이미 구현한 코드들을 쳐다도 보지 않는 와중에 테스트를 만들어 내는 시도는 의미가 없는 것 같으니, 앞으로 할 프로젝트에서는 테스트 코드를 착실하게 작성하며 구현을 하도록 해야 겠다.