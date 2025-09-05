plugins {
    id("com.android.application") version "8.3.2" apply false
    kotlin("android") version "1.9.24" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    kotlin("kapt") version "1.9.24" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
