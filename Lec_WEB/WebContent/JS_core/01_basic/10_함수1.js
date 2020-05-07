// function 함수이름 (매개변수...)

function add(a,b){
    return a+b;
}

var sum = add(1,2)
console.log("sum = ",sum)

//JS 에선 '함수(function)'도 데이터다!
console.log(typeof add);
console.log(add)

//따라서
//함수를 변수에 담을 수도 있고
//함수를 매개변수로 넘겨줄수도 있고
//함수를 리턴할수도 있다. 

//============================================
//JS는 함수 정의시 아래와 같은 표현을 더 선호함
//이름없는 함수 사용
var sub = function(a,b){
    return a-b
}
console.log(sub(10,3))
console.log(sub)

let mul = function(a,b){
    return a*b;
}
console.log(mul(4,5))

let bbb = mul;
console.log(bbb(5,5))

var arr = [add, sub, mul, bbb];

console.log(arr[0](10,20));