package com.cloudrader.inventarium.utils.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

@Service
class AesSecretEncryptionService(
    @Value("\${security.encryption.master-key}")
    private val masterKey: String
): SecretEncryptionService {
    private val algorithm = "AES"
    private val secretKey: SecretKeySpec

    init {
        val keyBytes = Base64.getDecoder().decode(masterKey)
        secretKey = SecretKeySpec(keyBytes, algorithm)
    }

    override fun encrypt(raw: String): String {
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encrypted = cipher.doFinal(raw.toByteArray())
        return Base64.getEncoder().encodeToString(encrypted)
    }

    override fun decrypt(encrypted: String): String {
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        val decoded = Base64.getDecoder().decode(encrypted)
        return String(cipher.doFinal(decoded))
    }
}