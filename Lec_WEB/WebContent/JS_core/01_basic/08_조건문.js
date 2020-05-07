// JAVA, C 언어와 구조 동일

a = 100;

if(a+1>100){
    let a = 10;
    console.log('if 안의 a 값은',a)
}

//조건식에서 참거짓 판정시!
// Falsy 로 평가될때!
// false, 0, '', null, undefine, NaN   <-- 'Falsy 한 값'이라 한다

// Truthy 로 평가될때
// true, 37, 'Mark', {}, []   <-- 'Truthy 한 값' 이라 한다

function print(data){
    if(data){ //참(Truthy) 거짓(Falsy)vkswjd
        console.log(data, typeof data, '-- Truthy');
    }else{
        console.log(data, typeof data, '-- Falsy');
    }
    
}

print(true);
print(false)
print(100)
print(0) // F
print(-1) 
print("Hello")
print("")
print([10,20,30])
print([]) //*파이썬과 다르다
print({'name':'John','age':32})
print({}) //*파이선과 다르다. 
print(null)
print(undefined)
print(NaN)
print(100/0)

print() //호출시 전달인자 없으면 undefined 값으로 동작

console.log()
console.log(!undefined)
console.log(!null)
console.log(!0)
console.log(!"")
console.log(!NaN)

//Truthy 값에 ! 결과 false (boolean)
console.log(!3)
console.log(!"Hello")
console.log(!" ")
console.log(![10,20,30])
console.log(![])
console.log(!{})


//truthy, falsy 판정결과 -->boolean
//1. 삼항 연산자 사용
let value = {'a':100}
let isTrue = value ? true:false;
console.log('isTrue = ',isTrue, typeof isTrue)

//2. !! 사용하면 가능
isTrue = !!value;
console.log('isTrue = ',isTrue, typeof isTrue)

console.log()

function printName(person){
    // 매개변수 null check
    //if(person===undefined||person===null)return;
    if(!person) return; //간단하게 해결
    console.log('이름은', person.name)
}

let myBrother = {name : "John"}

printName(myBrother)
printName() //undefined 에 .을 하려고 해서 에러