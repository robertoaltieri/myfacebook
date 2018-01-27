package com.mydrivesolutions.myfacebook.data

object TeamProvider {
    private val MIKEY = Person(
            "Mikey",
            "https://pre00.deviantart.net/a142/th/pre/f/2011/250/e/e/mickey_mouse_by_saber006-d496hdz.png",
            "https://i.pinimg.com/236x/ab/dc/56/abdc56dd06d09e8245208f72d1e9295b--disney-halloween-happy-halloween.jpg")
    private val DONALD = Person(
            "Donald",
            "http://www.pngall.com/wp-content/uploads/2017/03/Donald-Duck-PNG-HD.png",
            "http://webiconspng.com/wp-content/uploads/2017/09/Donald-Duck-PNG-Image-25299.png")
    private val SCROOGE = Person(
            "Scrooge",
            "https://upload.wikimedia.org/wikipedia/en/5/54/Scrooge_McDuck.png",
            "https://www.disneyclips.com/imagesnewb/images/scrooge_happy.gif")

    val ALL = arrayOf(MIKEY, DONALD, SCROOGE)
}