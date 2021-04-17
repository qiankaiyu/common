price = 684.71
company = new StringBuilder('Google')
quote = "Today $company stock closed at $price"

stocks = [Apple:663.01, MicroSoft:30.09]

stocks.each { key, value->
    // company = new StringBuilder(key) won't work
    company = company.replace(0, 10, key)
    price = value
    println quote
}

companyClosure = { it.write(company) }
priceClosure = { it.write("$price") }
quote = "Today $companyClosure stock closed at $priceClosure"
stocks.each { key, value->
    company = key
    price = value
    println quote
}

quote = "Today ${ ->company } stock closed at ${ ->price }"
stocks.each { key, value->
    company = key
    price = value
    println quote
}
