package it.unical.demacs.pierluigi.fintedapp.handler;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import ch.qos.logback.core.ConsoleAppender;
import it.unical.demacs.pierluigi.fintedapp.dto.utility.ServiceError;
import it.unical.demacs.pierluigi.fintedapp.exception.CredentialsAlreadyUsedException;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.InvalidArgumentException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @SuppressWarnings(value = { "all" })
    private ServiceError errorResponse (WebRequest req, String message) {
        HttpServletRequest httpreq = (HttpServletRequest) req.resolveReference("request");
        final ServiceError output = new ServiceError(new Date(), httpreq.getRequestURI(), message);
        log.error("Exception handler :::: {}", output.toString());
        return output;

    }
    
    @ExceptionHandler(
        {CredentialsAlreadyUsedException.class, 
            NullFieldException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            ValidationException.class,
            InvalidArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceError badRequest(WebRequest req, Exception ex){
        LoggerFactory.getLogger(ConsoleAppender.class).error(ex.getMessage(), ex);
        return errorResponse(req, ex.getMessage());
    }

    @ExceptionHandler({ElementNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ServiceError elementNotFound(WebRequest req, Exception ex){
        LoggerFactory.getLogger(ConsoleAppender.class).error(ex.getMessage(), ex);
        return errorResponse(req, ex.getMessage());
    }

    @ExceptionHandler(value={AccessDeniedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ServiceError handleDeniedAccessException(WebRequest req, AccessDeniedException ex) {
        LoggerFactory.getLogger(ConsoleAppender.class).error(ex.getMessage(), ex);
        return errorResponse(req, ex.getMessage());
    }

    @ExceptionHandler(value={Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceError handleException(WebRequest req, Exception ex) {
        LoggerFactory.getLogger(ConsoleAppender.class).error(ex.getMessage(), ex);
        return errorResponse(req, ex.getMessage());
    }

    @ExceptionHandler(value = {UnsupportedOperationException.class})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ServiceError handleUnsupportedOperationException(WebRequest req, Exception ex){
        LoggerFactory.getLogger(ConsoleAppender.class).error(ex.getMessage(), ex);
        return errorResponse(req, ex.getMessage());
    }
    

}
