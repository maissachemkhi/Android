package com.example.myapplication

class Dice (val numSlides: Int) {
        fun roll(): Int {
            return (1..numSlides).random()
        }
}