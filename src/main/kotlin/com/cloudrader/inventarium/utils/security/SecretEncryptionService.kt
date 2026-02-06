package com.cloudrader.inventarium.utils.security

interface SecretEncryptionService {
    fun encrypt(raw: String): String
    fun decrypt(encrypted: String): String
}