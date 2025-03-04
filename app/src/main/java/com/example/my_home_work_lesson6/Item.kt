package com.example.my_home_work_lesson6

class Item(
    @JvmField val title: String, val description: String, // Stores drawable resource ID
    @JvmField val imageResId: Int
) {
    inner class Title {
        fun toLowerCase() {

        }

    }
}

