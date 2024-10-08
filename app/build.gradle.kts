plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.helloworldmvvvmcleanarchitecture"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.helloworldmvvvmcleanarchitecture"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.navigation)
    implementation(libs.androidx.viewmodel.compose)
    implementation(libs.material3.html.text)


    implementation(libs.androidx.coroutines.core)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.lifecycle.runtime)

    //Glide
    implementation(libs.github.glide)
    //coil
    implementation(libs.io.coil)


    //Retrofit
    implementation(libs.squareup.retrofit)
    implementation(libs.square.converter.gson)
    implementation(libs.logging.interceptor)

    //Dagger dependency
    implementation(libs.google.dagger)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.test.monitor)
    implementation(libs.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose.android)
    ksp(libs.dagger.compiler)

    //Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.room.compiler)
    //plugin kapt

    implementation(libs.mockito.core.version)
    implementation(libs.arch.core.testing)

    implementation(libs.coroutines.test)
    implementation(libs.cash.turbine)

    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.core.testing)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}