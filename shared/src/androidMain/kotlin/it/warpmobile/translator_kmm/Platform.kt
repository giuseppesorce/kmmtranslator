package it.warpmobile.translator_kmm

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val home: String = "Home Android ${android.os.Build.MANUFACTURER}"
}

actual fun getPlatform(): Platform = AndroidPlatform()