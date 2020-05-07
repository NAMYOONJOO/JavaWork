// 화살표 함수 (ES6 도입)
// 함수를 정의하는 또 다른 방법
// 화살표 함수
// const 나 let 으로 시작

const add = (a,b)=>{
    return a+b;
}

let sum= add(1,2)
console.log(`sum=${sum}`)

const hello = name =>{
    console.log(`Hello, ${name}!`)
}

hello('헐크')

//리턴값이 있는 화살표 함수는
//더 간략하게 정의 가능

const add2 = (a,b)=>a+b
sum = add2(10,20);
console.log(`sum=${sum}`)