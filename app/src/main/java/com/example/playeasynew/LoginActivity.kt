package com.example.playeasynew

import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaSession2
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kakao.auth.AuthType
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.util.exception.KakaoException
import com.kakao.util.helper.Utility.getKeyHash
import com.kakao.util.helper.Utility.getPackageInfo
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

import kotlinx.android.synthetic.main.activity_main.*
class LoginActivity : AppCompatActivity() {
    private val logout: Button? = null
    private val sessionCutt: Button? = null


    private val kakaoSessionCallback : SessionCallback = SessionCallback()

    fun loginKakao(){
        Session.getCurrentSession().addCallback(kakaoSessionCallback)
        Session.getCurrentSession().open(AuthType.KAKAO_TALK, this)



    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var hash_key = getKeyHash(this)
        Log.i("Log", hash_key)

//        val btn_click = findViewById(R.id.login_button) as Button
//        ButterKnife.bind()
//        btn_click.setOnClickListener {
//            val nextIntent = Intent(this, SecondActivity::class.java)
////            val nextIntent=Intent(this,SecondActivity)
//            startActivity(nextIntent)
//        }

        Session.getCurrentSession().addCallback(kakaoSessionCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        Session.getCurrentSession().removeCallback(kakaoSessionCallback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            Log.d("get current session", "")
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    inner class SessionCallback : ISessionCallback {
        override fun onSessionOpenFailed(exception: KakaoException) {
            Log.d("session fail error",exception.message)
        }

        override fun onSessionOpened() {
            Log.d("세션 오픈 성공","")

        }


    }


}