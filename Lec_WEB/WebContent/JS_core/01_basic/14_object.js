//object
console.log('object');

//property:value 쌍
x = {firstName: "John" , lastName: "Doe"};
console.log(x, typeof x);

console.log(x.firstName);
console.log(x['firstName']);
console.log(x['firstName'],typeof x.firstName);

//object 는 length 값 없다.
console.log(x.length);

//for ~ in 사용가능
for(key in x){ //property가 추출됨.  (String)
console.log(`x[${key}] = ${x[key]}`)
};

// value 는 어떠한 타입이라도 가능!
x = {
    name : "kim"
    , age : 34
    , height : 172.3
    , score : [94,35,79]
    , sayHello : function(){
        console.log("안냐세요");
    }
    , getScore : function(n){
        return this.score[n]; //this 빼면 에러!. 동일 object 의 property 접근할때 this 사용!
    }
    , getTotal : function(){
        var result=0;
        for(i = 0;i<this.score.length;i++){
            result+=this.score[i];
        }
        return result
    }
    , getAvg : function(){
        return (this.getTotal()/this.score.length).toFixed(2); //소수점 2자리 
    }
};

console.log(x['name'], typeof x['name']);
console.log(x.age, typeof x.age);
console.log(x['height'], typeof x['height']);
console.log(x.score, x.score.length);
x.sayHello();
console.log(x.getScore(0));
console.log(x.getTotal());
console.log(x.getAvg());
console.log(x['getAvg']())


//p:v 추가/삭제/변경
x = {firstName: "John" , lastName: "Doe"};
console.log(x);
x.firstName="Mike" //변경
console.log(x);

x['age'] = 45;// 없던 property 추가
console.log(x)

delete x.firstName;
console.log(x);

//없는 property 접근하려 하면
console.log(x.firstName)//undefined

//---------------------------------------------
//console.log(a);
var b
console.log(b); //undefined

//함수가 object 생성자로 사용 가능
function Person(firstName,lastName,age){
    this.firstName = firstName;
    this.length = lastName;
    this.age = age;
   // console.log(this)
}
var p1 = new Person('aaa','bbb',33)
console.log(p1)

var p2 = new Person('김','우똥',103)
console.log(p2)