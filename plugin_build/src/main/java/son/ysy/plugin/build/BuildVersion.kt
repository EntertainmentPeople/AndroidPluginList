package son.ysy.plugin.build

sealed class BuildVersion<T>(val newest: T) {
    fun custom(value: T) = value

    object CompileSdk : BuildVersion<Int>(30)

    object MinSdk : BuildVersion<Int>(21)

    object TargetSdk : BuildVersion<Int>(30)

    object BuildTools : BuildVersion<String>("30.0.2")
}