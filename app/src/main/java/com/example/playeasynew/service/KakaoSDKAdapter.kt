package com.example.playeasynew.service
import android.os.Parcel
import android.os.Parcelable
import com.kakao.auth.*


class KakaoSDKAdapter() :KakaoAdapter() {

    override fun getSessionConfig(): ISessionConfig {
        return object:ISessionConfig{
            override fun isSaveFormData(): Boolean {
                TODO("Not yet implemented")
            }

            override fun getAuthTypes(): Array<AuthType> {
                TODO("Not yet implemented")
            }

            override fun isSecureMode(): Boolean {
                TODO("Not yet implemented")
            }

            override fun getApprovalType(): ApprovalType? {
                TODO("Not yet implemented")
            }

            override fun isUsingWebviewTimer(): Boolean {
                TODO("Not yet implemented")
            }


        }
    }



    override fun getApplicationConfig(): IApplicationConfig {
        TODO("Not yet implemented")
    }



}