package com.ckrbqja.issue.exception

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.naming.ldap.ExtendedResponse


@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handlerServerException(ex: ServerException): ErrorResponse {
        logger.error { ex.message }


        with(ex) {
            return ErrorResponse(code.value(), message);
        }
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: ServerException): ErrorResponse {
        logger.error { ex.message }

        return ErrorResponse(INTERNAL_SERVER_ERROR.value(), "서버 에러 발생");
    }
}