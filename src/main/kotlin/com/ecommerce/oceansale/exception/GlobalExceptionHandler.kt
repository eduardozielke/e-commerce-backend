package com.ecommerce.oceansale.exception

import jakarta.persistence.EntityNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import java.util.*


@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, req: WebRequest): ResponseEntity<ErrorResponse?>? {

        val path = (req as ServletWebRequest).request.requestURL.toString()
//        LOGGER.error(ex.message, ex.printStackTrace())

        val errorResponse = when(ex) {
            is EntityNotFoundException -> {
                ErrorResponse(
                    ex.message!!,
                    HttpStatus.NOT_FOUND.value(),
                    path
                )
            }

            is MethodArgumentNotValidException -> {
                val errors = ex.bindingResult.fieldErrors.map { it.defaultMessage ?: ex.message }
                val message = errors.joinToString("; ")
                ErrorResponse(
                    message,
                    HttpStatus.BAD_REQUEST.value(),
                    path
                )
            }

//            is DataIntegrityViolationException -> {
//                ErrorResponse(
//                    "There was a data integrity violation. ${ex.mostSpecificCause.message}",
//                    HttpStatus.BAD_REQUEST.value(),
//                    path
//                )
//            }

            else -> {
                logger.error(ex.message, ex.printStackTrace())
                ErrorResponse(
                    ex.message!!,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    path,
                )
            }
        }

        return ResponseEntity(errorResponse, HttpStatus.valueOf(errorResponse.status))
    }
}