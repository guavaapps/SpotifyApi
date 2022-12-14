package com.pixel.spotifyapi.Objects;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import retrofit.http.RestMethod;

@Documented
@Target(METHOD)
@Retention(RUNTIME)
@RestMethod(value = "DELETE", hasBody = true)
public @interface DELETEWITHBODY {
    String value ();
}
