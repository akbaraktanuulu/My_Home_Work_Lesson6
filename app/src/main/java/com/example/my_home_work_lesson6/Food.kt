package com.example.my_home_work_lesson6

class Food(@JvmField var name: String, @JvmField var avatar: String) {
    override fun toString(): String {
        return buildString {
            append("Food{")
            append("name='")
            append(name)
            append('\'')
            append(", avatar='")
            append(avatar)
            append('\'')
            append('}')
        }
    }
}