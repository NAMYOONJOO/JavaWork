// 자료형 : data type

//  https://developer.mozilla.org/ko/docs/Web/JavaSCript/Data_structures

// 동적타이핑 (dynamic type)
// 변수는 고정타입이 없다

// runtime 에 개발자가 모르는 어떤 타입의 값이
// 들어올수 있다  주의!

// 데이터 타입
// 1.기본타입 (primitive)
//  -- boolean
//  -- null
//  -- undefined
//  -- number
//  -- string
//  -- symbol (ES6 에 추가)
//
// 2. 객체 (object)
//   ..

//--------------------------------------------
//boolean 타입
//true/ false
{
    const istTrue = true;
    const isFalse = false;

    console.log(`isTrue = ${istTrue}`,typeof isTrue)
    console.log(`isFalse = ${isFalse}`,typeof isFalse)

    if(istTrue){
        console.log(istTrue,'참 입니다');
    }else{
        console.log(istTrue, '거짓입니다.')
    }

    //객체로 생성가능
    //가능은 하지만 비추

    const a = new Boolean(false);// false값을 같은 Boolean객체
    console.log(`a=`,a);
    console.log(`a = `,a,typeof a); //object

    if(a){//<- new를 사용하여 생성하면 조건식에서 '참'으로 판정된다. !!
        console.log(a, '참입니다.')
    }else{
        console.log(a, '거짓입니다.')

    }

    //new 를 사용하지 않고 boolean  만들기
    const b= Boolean(false); //Boolean 함수 
    console.log(`b = `,b,typeof b); //boolean
}
console.log('\n')
console.log('\n')
console.log('\n')
console.log('\n')
console.log('\n')
//null======================================================
//값이 없는 object
{
    const a = null;
    console.log('a=',a,typeof a);


}

// undefined================================================
//아무값도 대입 안된 상태 
{
    let b; //아무값도 대입 안된 상태, undefined
    console.log('b=',b,typeof b)

    let a = 10;
    a = undefined;//다시 undefined 로 대입가능
    console.log('a=',a,typeof a)
    
    a = null;b = undefined;
    if(a==b){ // == : 값이 같아지면 비교
        console.log('같습니다.')
    }else{
        console.log('다릅니다.')
    }

    if(a===b){ // === : 값 뿐만 아니라 type까지 비교 
        console.log('같습니다.')
    }else{
        console.log('다릅니다.')
    }
    //가급적 JS 프로그래밍에 작성시 ==보단 ===추천
    //!= 보단 !==추천

}

//===========================================
//number
console.log('\n<number>')
{
    //실수이든 정수이든 모두 number 타입
    const a = 37;
    console.log('a = ', a , typeof a)
    const b = 3.14;
    console.log('b = ', b , typeof b)

    const c = NaN; //Not a Number
    console.log('c=',c,typeof c);

    let d = Number(123);
    console.log('d=',d,typeof d);//number

    d = Number('123')//number로 형변환됨
    console.log('d=',d,typeof d);//number

    d = Number('Mark')//number로 형변환 XX
    console.log('d=',d,typeof d);// NaN

    d = parseInt('123') //이또한 Number로 형변환
    console.log('d=',d,typeof d);// Number

    d = parseInt('alice') 
    console.log('d=',d,typeof d);// NaN

    d = parseFloat('3.14'); //number
    d*=2;
    console.log('d =', d, typeof d);

    d = parseInt('3.14'); //number
    console.log('d =', d, typeof d);

    d = parseInt('300')
    console.log('d =', d, typeof d);

    num1 = 100; num2 = '100';
    if(num1==num2){//==<--값을 비교
        console.log(`${num1}==${num2} 같다`)
    }else{
        console.log(`${num1}==${num2} 다르다`)
        
    }

    if(num1==num2){//=== <--값과 타입 비교
        console.log(`${num1}==${num2} 같다`)
    }else{
        console.log(`${num1}==${num2} 다르다`)
        
    }
    

}

console.log('\n<string>')
{
    let a = 'Mark'
    console.log('a = ',a,typeof a)

    a = "Mark"
    console.log('a = ',a,typeof a)

    a = "she's gone"
    console.log('a = ',a,typeof a)

    a = ' he says "Hello"'
    console.log('a = ',a,typeof a)

    a = "he says \"I'm fine\""
    console.log('a = ',a,typeof a)

    //+문자열 연산
    a = 'Mark'
    let b = a+" Hamill";
    console.log('b = ',b,typeof b)

    console.log(a*2) //NaN

    //문자열 비교연산 가능//코드순 비교
    //대문자 < 소문자
    if("a">"b"){
        console.log('참입니다.')

    }else{
        console.log('거짓입니다.')
    }
}

//-------------------------------------------------
// symbol
// ES6 부터 출현
// https://developer.mozilla.org/ko/docs/Glossary/Symbol

// '고유'한 값을 만들어낼때 사용

console.log('\n<symbol>');
{
    const a = Symbol(); //new  사용하면 안됨
    const b = Symbol(37);
    const c = Symbol('Mark');
    const d = Symbol('Mark'); //c와 d는 같은 것이 아니다. 
    //'고유'한 Symbol 객체로 만들어진다. 

    console.log('a =',a,typeof a);
    console.log('b =',b,typeof b);
    console.log('c =',c,typeof c);
    console.log('d =',d,typeof d);
    
    console.log(c==d)
    console.log(c===d)
}