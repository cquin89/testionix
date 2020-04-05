package com.losingtimeapps.testionix.util

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

class Utils {

    companion object {

        private const val desKey = "ionix123456"

        fun desEncryption(text: String): String {
            val keySpec = DESKeySpec(desKey.toByteArray(charset("UTF8")))
            val keyFactory: SecretKeyFactory = SecretKeyFactory.getInstance("DES")
            val cleartext: ByteArray = text.toByteArray(Charsets.UTF_8)
            val cipher: Cipher = Cipher.getInstance("DES")
            val key: SecretKey = keyFactory.generateSecret(keySpec)
            cipher.init(Cipher.ENCRYPT_MODE, key)
            return Base64.encodeToString(cipher.doFinal(cleartext), Base64.NO_WRAP)

        }

    }
}