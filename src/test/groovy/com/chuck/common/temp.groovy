package com.chuck.common

// // 如何在命令行执行中指定具体的jar？
// import groovy.sql.Sql
// import com.chuck.common.model.Student

// def db = [url:'jdbc:mysql://localhost:3306/test', user:'chuck', password:'asdasd123', driver:'com.mysql.jdbc.Driver']
// def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

// def sysdate = sql.firstRow("select date_format(now(),'%Y-%m-%d %H:%i:%s') from dual")
// println sysdate

// 0..3.foreach { println 'Merry Groovy' }

// for (i in 0..2) println 'Merry Groovy'
// 0.upto(3) { println 'Merry Groovy' }
// 3.times { println 'Merry Groovy' }

class Car {

    def     miles
    final year

    Car(def year) {
        this.year = year
    }

}
// Car car = new Car(2008)
// println "${car.year}"
// println "${car.miles}"
// car.miles = 25
// println "${car.miles}"

// 2.1.2
// 0.upto(2) { println 'no' }
// 3.times { println 'no' }
// (0..<3).forEach{println 'no'}
// for(i in 0..2){println 'no'}

// 2.1.3
// println "groovy -v".execute().text

// 2.3
// class Robot{
//     def type,width,height
//     def access(location,weight,fragile){
//         println "Received Fragile? $fragile,Weight? $weight,Location? $location"
//     }
// }
// rob=new Robot("type":"arm","width":10,"height":40)
// println "$rob.type,$rob.width,$rob.height"
// rob.access(type:30,width:20,height:10,50,true)
// rob.access(50,true,x:30,y:20,z:10)

// 2.4
// def log(base=10,x){Math.log(x)/Math.log(base)}
// println log(1024) //log(10,1024)
// println log(1024,10) //log(1024,10)
// println log(1024,2)  //log(1024,2)

// def task(name,String[] details){println "$name-$details"}
// task "call","123-456-7890"
// task "call","123-456-7890","234-567-8901"
// task "Check Mail"

// 2.5
// def spiltName(name){name.split(" ")}
// def (xing,ming)=spiltName("yu chuck")
// println "xing: $xing, ming:$ming"
// def (name1,name2)=["name1"]
// println "$name1,$name2"

// 2.6
// {} as Interface
// [closure1:{},closure2:{}] as Interface
