plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //    added
    alias(libs.plugins.android.dagger.hilt)
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "cl.rodrigojavier101.monitordelapoliticachilena"
    compileSdk = 35

    defaultConfig {
        applicationId = "cl.rodrigojavier101.monitordelapoliticachilena"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        // added
        buildConfig = true
        viewBinding = true
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // ###########
    implementation(libs.androidx.appcompat)

    //*splashscreen*//*
    implementation(libs.androidx.splash)
    //*navigation NO CAMBIAR LA VERSION "2.6.0" **************//*
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.fragmentktx)
    implementation(libs.androidx.legacy)
    //*picasso*//*
    implementation(libs.androidx.picasso)
    // constraint layout
    implementation(libs.androidx.constraintlayout)
    //    coroutines
    implementation(libs.androidx.coroutines)
    implementation(libs.androidx.coroutinesandroid)
    //   coroutine lifecycle scopes
    implementation(libs.androidx.activityktx)
    implementation(libs.androidx.lifecyclesextensions)
    implementation(libs.androidx.lifecycle)
    // KTX - Viewmodel Y Livedata NO ACTUALIZAR: 2.5.1
    implementation(libs.androidx.lifecycle.livedata)
    //    data store
    implementation(libs.androidx.datastore)
    //    retrofit
    implementation(libs.androidx.retrofit)
    implementation(libs.androidx.retrofitgson)

    implementation(libs.googlegson)

    implementation(libs.okhttp)
    implementation(libs.okhttp.interceptor)
    //*implementacion para el carrousel*//*
    // Optional: Circle Indicator (To fix the xml preview "Missing classes" error)
    implementation(libs.circleindicator)
    implementation(libs.carrousel)
    //*material design*//*
    implementation(libs.materialgoogle)
    implementation(libs.jsoup)
    //Room
    implementation(libs.room)
    // kapt genera el codigo para la base de datos
    kapt(libs.roomkaptcompiler)
// migrating to ksp
    /* <><><><> *//* <><><><> *//* <><><><> *//* <><><><> */
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
// TEST unitarios
    testImplementation(libs.junit)

//   added tests MOKK y mockito
    testImplementation(libs.mokk)
    testImplementation(libs.mockitocore)
    testImplementation(libs.mockitoinline)

// TEST
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //   dagger hilt
    implementation(libs.dagger.google)
    implementation(libs.androidx.hilt.navigation.compose.v120)
    annotationProcessor(libs.androidx.google.compiler)
    kapt(libs.androidx.google.dagger.kapt.android)
    kapt(libs.androidx.google.compiler)
    kapt(libs.androidx.hilt.compiler.v120)

}
kapt { correctErrorTypes = true }