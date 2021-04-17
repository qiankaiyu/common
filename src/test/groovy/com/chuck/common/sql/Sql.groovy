def sql = groovy.sql.Sql.newInstance('jdbc:mysql://localhost:3306/test', 'test', 'asdasd123', 'com.mysql.cj.jdbc.Driver')
println sql.connection.catalog

sql.eachRow('select * from weather') {
    println it.city + ' ' + it[1]
}

