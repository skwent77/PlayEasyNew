package com.example.playeasynew.application

import android.app.Application
import com.example.playeasynew.service.KakaoSDKAdapter
import com.kakao.auth.KakaoSDK

class PlayeasyApplication: Application() {
     val TOKEN : String = ""

    override fun onCreate() {
        super.onCreate()

        instance = this
        KakaoSDK.init(KakaoSDKAdapter())
    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }

    fun getGlobalApplicationContext(): PlayeasyApplication {
        checkNotNull(instance) { "this application does not inherit com.kakao.GlobalApplication" }
        return instance!!
    }

    companion object {
        var instance: PlayeasyApplication? = null
    }




}