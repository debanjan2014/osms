package com.malikov.shopsystem.util;

import com.malikov.shopsystem.HasId;
import com.malikov.shopsystem.util.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yurii Malikov
 */
public class ValidationUtil {

    public static Map<String, String> constraintCodeMap = new HashMap<String, String>() {
        {
            put("email", "exception.sorryEmailIsNotFree");
            put("seat", "exception.sorrySeatIsNotFreeAlready");
            put("null", "exception.notFound");
        }
    };

    private ValidationUtil() {
    }

    public static <T> T checkNotFoundById(T object, Long id) {
        checkNotFoundById(object != null, id);
        return object;
    }

    public static void checkNotFoundById(boolean found, Long id) {
        if (!found) {
            throw new NotFoundException("not found with id=" + id);
        }
    }

    public static <T> T checkNotFound(T object, String message) {
        checkNotFound(object != null, message);
        return object;
    }

    public static void checkNotFound(boolean found, String message) {
        if (!found) {
            throw new NotFoundException(message);
        }
    }

    public static void validate(boolean valid, String message) {
        if (!valid) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkIsNotNew(HasId bean, String message) {
        if (bean.isNew()) {
            throw new IllegalArgumentException(bean.toString() + message);
        }
    }

    public static void checkIsNew(HasId bean, String message) {
        if (!bean.isNew()) {
            throw new IllegalArgumentException(bean.toString() + message);
        }
    }

    public static <T> void checkNotEqual(T firstObject, T secondObject, String message) {
        if (firstObject != null && secondObject != null) {
            validate(!firstObject.equals(secondObject), message);
        }
    }

    public static <T> void checkEqual(T firstObject, T secondObject, String message) {
        if (firstObject != null && secondObject != null) {
            validate(firstObject.equals(secondObject), message);
        }
    }

    public static void validateFromToDates(LocalDateTime fromDateTime,
                                           LocalDateTime toDateTime,
                                           String message) {
        if (fromDateTime != null && toDateTime != null) {
            validate(fromDateTime.compareTo(toDateTime) < 0, message);
        }
    }

    public static Throwable getRootCause(Throwable t) {
        Throwable result = t;
        Throwable cause;

        while (null != (cause = result.getCause()) && (result != cause)) {
            result = cause;
        }
        return result;
    }

    public static ResponseEntity<String> chechBindingResultHasErrors(BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors()
                    .forEach(fe -> sb.append(fe.getField())
                            .append(" ")
                            .append(fe.getDefaultMessage())
                            .append("<br>"));
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
