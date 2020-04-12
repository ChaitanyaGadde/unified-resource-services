package com.unified.resource.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
    @ApiImplicitParam(name = "X-Client", value = "The calling client", required = true,
        dataType = "string", paramType = "header"),
    @ApiImplicitParam(name = "X-Transaction-ID", value = "The transaction Id", required = true,
        dataType = "string", paramType = "header")})
public @interface RequiredHeaderParams {
}
