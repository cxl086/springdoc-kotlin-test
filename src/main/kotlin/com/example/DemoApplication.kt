package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

@RestController
class DemoController {
    @GetMapping("/demo")
    fun demo(): B = B(A(1))
}


fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}

data class A(val num: Int)


class B(a: A) {
    val numFromA = a.num
}
