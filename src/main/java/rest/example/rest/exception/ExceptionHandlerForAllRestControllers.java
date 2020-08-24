package rest.example.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// I DON'T WANT TO USE THE SAME
//      @ExceptionHandler
//      public ResponseEntity<ModelErrorResponse> handleException(ModelNotFoundException exc){
// METHODS IN EVERY REST CONTROLLER... IT'S BOILER PLATE CODE

// THE BEST SOLUTION IS TO CREATE CLASS THAT WILL INTERCEPT EVERY REST CONTROLLER
// AND IF THERE IS EXCEPTION, THEY WILL COME HERE AND LOOK FOR SOLUTION @ExceptionHanlder

// SO I WILL CREATE EVERY METHOD FOR EXCEPTION HANDLING AND IT'S HANDLE EVERY REST
// CONTROLLER EXCEPTION

@ControllerAdvice
public class ExceptionHandlerForAllRestControllers {

    //before this class, this code were in @RestController class, so i moved it here
    //add exception code here

    //exception for @GetMapping("/organizers/{id}")   ----   example    BUT I WILL NEED TO ADD SOME CONDITION IN THAT METHOD IN @RestController class
                                                                        // to throw new ModelNotFoundException("Organizer id not found - " + id);
    //add an exception handler using @ExceptionHandler
    //method above wont work without this
    @ExceptionHandler //if exception occurred anywhere this will handle that exception
    public ResponseEntity<ModelErrorResponse> handleException(ModelNotFoundException exc){
        //create a ModelErrorResponse
        ModelErrorResponse error = new ModelErrorResponse();
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setMessage(exc.getMessage());
            error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //another exception for @GetMapping("/organizers/{id}")
    //if i type some text instead id
    //body of this method is same as method above, difference is status message
    @ExceptionHandler
    public ResponseEntity<ModelErrorResponse> handleException(Exception exc){
        //create a ModelErrorResponse
        ModelErrorResponse error = new ModelErrorResponse();
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            error.setMessage(exc.getMessage());
            error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
