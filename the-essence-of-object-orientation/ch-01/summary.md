# 1장 | 협력하는 객체들의 공동체
🔥 객체지향 개념에 대한 올바른 이해

<br>

## 💻 실세계의 모방

- 객체지향의 목표는 실세계를 모방하는 것이 아니다. 오히려 새로운 세계를 **창조**하는 것이다.
- 실세계에 대한 비유는 객체지향의 사상을 이해하고 학습하는 데 매우 효과적일 뿐이다.

<br>

## 💻 역할, 협력, 책임

- 실세계의 사람들이 협력하는 과정은 객체지향의 근본 개념과 유사하다.
- 사람들은 협력을 위해 특정한 역할을 맡고 역할에 적합한 책임을 수행한다.
- 시스템은 역할과 책임을 수행하는 객체로 분할되고, 시스템의 기능은 객체 간의 연쇄적인 요청과 응답의 흐름으로 구성된 협력으로 구현된다.
- 책임은 객체지향 설계의 품질을 결정하는 가장 중요한 요소다. 객체지향 설계는 적절한 객체에게 적절한 책임을 할당하는 것에서 시작된다.

<br>

## 💻 협력 속에 사는 객체

- 객체는 상태(state)와 행동(behavior)을 함께 지닌 실체이다.
- 협력의 품질을 결정하는 것은 객체의 품질이다.

### 객체는 충분히 '협력적'이어야 한다.
- 다른 객체의 요청에 귀 기울여 응답하고, 적극적으로 도움을 요청해야 한다.
- 전지전능한 객체는 내부적인 복잡도에 의해 자멸하고 만다.

### 객체는 충분히 '자율적'이어야 한다.
- 공동의 목표를 달성하기 위해 협력에 참여하지만, 스스로의 결정과 판단에 따라 행동해야 한다.
- 객체의 내부와 외부를 명확히 구분해야 한다.
- 다른 객체가 '무엇(what)'을 수행하는지는 알 수 있지만 '어떻게(how)' 수행하는지에 대해서는 몰라야 한다.

### 객체는 메시지로 협력한다.
- 객체지향에서 협력은 메시지를 전송하는 객체, 송신자(sender)와 수신하는 객체, 수신자(receiver)의 관계로 구성된다.
- 객체는 송수신 메시지를 자신만의 메서드(method)를 통해 자율적으로 처리한다.

<br>

## 💻 객체지향의 본질

1. 객체지향이란 시스템을 상호작용하는 **자율적인 객체들의 공동체**로 바라보고, 객체를 이용해 시스템을 분할하는 방법이다.
2. 자율적인 객체란 **상태**와 **행위**를 함께 지니며 스스로 자기 자신을 책임지는 객체를 의미한다.
3. 객체는 시스템의 행위를 구현하기 위해 다른 객체와 **협력**한다. 각 객체는 협력 내에서 정해진 **역할**을 수행하며 역할은 관련된 **책임**의 집합이다.
4. 객체는 다른 객체와 협력하기 위해 메시지를 전송하고, **메시지**를 수신한 객체는 메시지를 처리하는 데 적합한 **메소드**를 자율적으로 선택한다.

> 💡 객체지향의 핵심은 적절한 책임을 수행하는 역할 간의 유연하고 견고한 협력 관계를 구축하는 것이다. 따라서 중요한 것은 클래스들의 정적인 관계가 아니라 메시지를 주고받는 객체들의 동적인 관계다.

<br>

## 📝 느낀점

1장은 객체지향의 목적과 본질에 대해 처음부터 차근차근 짚고 넘어가는 장이다. 현실 세계의 인간 사이의 관계를 바탕으로 객체의 특성과 관계를 이해했고, 다시 한 번 머리에 새겼다.
객체지향의 중심이 클래스가 아닌 객체라는 점, 그리고 객체의 동적인 관계를 구성하는 것이 개발자가 할 일이라는 것을 다시 한 번 느낄 수 있었다.
