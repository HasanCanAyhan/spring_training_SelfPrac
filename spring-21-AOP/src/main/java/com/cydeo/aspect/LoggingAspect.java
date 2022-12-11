package com.cydeo.aspect;


import com.cydeo.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //defining the my join point

    /*
    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
    public void myPointcut(){



    }

    //what we need to do , before or after : advice
    @Before("myPointcut()")
    public void log(){
        logger.info("Info log............");
    }


     */

    /* we can also write this : same thing above
    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
    public void log(){
        logger.info("Info log............");
    }

     */

    /*

    // before findById method : specific
    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    public void courseRepositoryFindByIdPC() {}

    @Before("courseRepositoryFindByIdPC()")
    public void beforeCourseRepositoryFindById(JoinPoint joinPoint) {
        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }


     */


    /*
    //within
    @Pointcut("within(com.cydeo.controller..*)")
    public void anyControllerOperation() {}

    //@within
    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void anyServiceOperation() {}

    @Before("anyControllerOperation() || anyServiceOperation()")
    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }

     */


    /*
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void anyDeleteControllerOperation() {}

    @Before("anyDeleteControllerOperation()")
    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }

     */


    /*
    //custom annotation
    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC(){}

    @Before("loggingAnnotationPC()")
    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }

     */



    //AFTER RETURNING

    /*
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void afterReturningGetMappingAnnotation() {}


     */

    /*
    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()",returning = "result")
    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result){
        logger.info("After Returning -> Method: {}, Result: {}" , joinPoint.getSignature(),result.toString());
    }

     */

    // i will use same pointcut
    /*
    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()",returning = "results")
    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results){
        logger.info("After Returning -> Method: {}, Result: {}" , joinPoint.getSignature(),results.toString());
    }

    //in java, CourseDTO -> Object
    //List<CourseDTO>  -> List<Object>  --->> this is not OK


     */

    /*
    // i will use same pointcut

    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()",throwing = "exception")
    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception) {
        logger.error("After Throwing -> Method: {}, Exception: {}", joinPoint.getSignature().toShortString(),exception.getMessage());
    }


     */




}
