package com.ckrbqja.issue.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*

sealed class ServerException(
        val code: HttpStatus,
        override val message:String
) : RuntimeException(message)


data class NotFoundException(
    override val message: String,
): ServerException(NOT_FOUND, message)

data class UnauthorizedException(
        override val message: String = "인증정보가 잘못되었습니다."
): ServerException(UNAUTHORIZED, message )
