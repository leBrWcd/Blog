package com.lebrwcd.blog.exc;/**
 * @author lebrwcd
 * @date 2022/6/20
 * @note
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ClassName ServerError
 * Description TODO
 *
 * @author lebr7wcd
 * @version 1.0
 * @date 2022/6/20
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerError extends RuntimeException{
    public ServerError() {
        super();
    }

    public ServerError(String message) {
        super(message);
    }
}
