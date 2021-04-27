package com.proiect.catalog.exception;

import com.proiect.catalog.web.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDto handleNotFound(HttpServletRequest request, Exception exception) {
        BaseException baseException = (BaseException) exception;

        logger.warn("Not found exception", exception);
        return new ErrorDto(baseException.getErrorCode(),
                baseException.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(HttpServletRequest request, Exception exception) {
        logger.error("An error occurred", exception);
        return new ErrorDto("internal.server.error", "An error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
