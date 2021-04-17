// class RefactorBegin {

//     def statement(invoice, plays) {
//         def totalAmount = 0

//         def volumeCredits = 0

//         def result = 'Statement for ${invoice.customer}\n'

//         def format=new Intl.NumberFormat("en-US",{style:"currency",currency:"USD",minimumFractionDigits:2}).format;
//         for (def perf  in invoice.performances) {
//             def play=plays[perf.playID]
//             def thisAmount=0

//             switch(play.type){
//                 case "tragedy":
//                     thisAmount=40000
//                     if(perf.audience>30){
//                         thisAmount+=1000*(perf.audience-30)
//                     }
//                     break
//                 case "comedy":
//                     thisAmount=30000
//                     if(perf.audience>20){
//                         thisAmount+=10000+500*(perf.audience-20)
//                     }
//                     thisAmount+=300*perf.audience
//                     break
//                 default:
//                     throw new Exception('Unknow type: ${play.type}')
//             }

//             volumeCredits+=Math.max(perf.audience-30,0)

//             if("comedy"==play.type){
//                 volumeCredits+=Math.floor(perf.audience/5)
//             }
//             result+='${play.name}:${format(thisAmount/100)} (${perf.audience} seats\n)'
//             totalAmount+=thisAmount
//         }
//         result+='Amount owed is ${format(totalAmount/100)}\n'
//         result+='You earned ${volumeCredits} credits\n'
//         return result
//     }

// def amountFor(perf,play){
//     def thisAmount=0
//     switch(play.type){
//                 case "tragedy":
//                     thisAmount=40000
//                     if(perf.audience>30){
//                         thisAmount+=1000*(perf.audience-30)
//                     }
//                     break
//                 case "comedy":
//                     thisAmount=30000
//                     if(perf.audience>20){
//                         thisAmount+=10000+500*(perf.audience-20)
//                     }
//                     thisAmount+=300*perf.audience
//                     break
//                 default:
//                     throw new Exception('Unknow type: ${play.type}')
//     }
// }

// }
