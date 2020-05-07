// 식별자 : identifier
// 코드내의 변수, 함수, 혹은 속성을 식별하는 문자열
// 대소문자 구분!
// 유니코드문자(한글도 가능), $, _, 숫자 사용 가능
// 숫자로 시작하면 안됨
// 예약어 불가, 공백불가

// 작명하는 것은 결코 쉬운 일은 아니다.
// 의미없는 이름 사용하지 말고, 역할에 맞는 적절한 이름을 짓도록 노력해야 한다.

var name = 'Mark';//변수 name(식별자)
function hello() {} // 함수 hello (식별자)
var person = {name: 'Mark', age:37} //변수 person(식별자)

//다음 두개 변수는 다른 변수다 (식별자는 대소문자 구분한다.)
var myName = 'Mark'
var myname = 'Mark'

var name1;
var $name;
var _name;
var 이름; //가능은 하지만 비츄

// 유효한 자바스크립트 식별자인지 확인하는 사이트
// https://mothereff.in/js-variables

console.log("\n프로그램 ㅗㅗㅗㅗ\n\n\n\n\n\n\n")