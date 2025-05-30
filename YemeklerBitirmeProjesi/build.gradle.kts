// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    dependencies{

        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.10")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")

    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}