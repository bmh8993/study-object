### 객체 지향 설계
객체 지향은 말 그래도 객체를 지향하는 것이다.  클래스가 아닌 객체에 초점을 맞출 때에만 얻을 수 있다. <br>
1. 어떤 클래스가 필요할지를 고민하기 전에 어떤 객체들이 필요한지 고민해라.클래스는 공통적인 상태와 행동을 공유하는 객체들을 추상화한 것이다.
2. 객체를 독립적인 존재가 아닌 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야한다. <br>

추상객체를 통해 의존성을 주입 받았을 시에 클래스 사이의 의존성과 객체 사이의 의존성이 동일하지 않을 수 있다. 그리고 유연하고, 쉽게 재사용할 수 있으며, 확장 가능한 객체지향 설계가 가지는 특징은 코드의 의존성과 실행 시점의 의존성이 다르다는 것이다. <br>

### 의존성  
코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드를 이해하기 어려어진다는 것이다. <br>
반면 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드는 더 유연해지고 확장 가능해 진다. <br>
이와 같은 의존성의 양면성은 설계가 트레이드오프의 산물이라는 것을 보여준다. <br>
유연성과 가독성 사이에서 고민해야 한다. 무조건 유연한 설계도, 무조건 읽기 쉬운 코드도 정답은 아니다.

### 다형성
컴파일 시점이 아닌 실행 시점에 결정하는것을 지연 바인딩 또는 동적 바인딩이라고 부른다.<br>
전통적인 함수 호출처럼 컴파일 시점에 실행된 함수나 프로시저를 결정하느 ㄴ것을 초기 바인딩 또는 정적 바인딩이라고 부른다.<br>
객체지향이 컴파일 시점의 의존성과 실행 시점의 의존성을 분리하고, 하나의 메시지를 서로 다른 메소드에 연결할수 있는 이유는 지연 바인딩 메커니즘을 사용하기 때문이다.

### 추상화의 힘
세부적인 내용을 무시한 채 상위 정책을 쉽고 간단하게 표현할 수 있다. <br>
즉 세부사항에 억눌리지 않고 상위 개념만으로도 도메인의 중요한 개념을 설명할수 있게 한다. (금액 할인 정책, 비율 할인 정책을 추상화된 할인 정책으로 표현할수 있다.)<br>
추상화를 이용해 상위 정책을 표현하면 기존 구조를 수정하지 않고도 새로운 기능을 쉽게 추가하고 확장할 수 있다. 다시 말해 설계를 유연하게 한다.

### 상속
상속은 코드를 재사용 하기 위해서 널리 사용되지면 캡슐화와 유연성에서 설계에 안좋은 영향을 미친다.<br>
상속을 이요하기 위해서는 부모 클래스의 내부 구조를 잘 알고 있어야 한다. 결과적으로 자식 클래스가 부모 클래스에 강하게 결합되도록 만들기 때문에 부모 클래스의 변경 시 자식 클래도 함께 변경될 가능성이 높다.<br>
또한 상속은 컴파일 시점에 부모와 자식 클래스 사이의 관계를 결정하기 때문에 실행 시점에 객체의 종류를 변경하는것이 불가능 하다.