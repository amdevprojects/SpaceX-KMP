package pro.kotlinmultiplatform.spacex

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform