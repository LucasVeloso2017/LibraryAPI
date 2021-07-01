package br.com.library.api.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    /*
    @Autowired
    private MessageSource messageSource;
    */

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ExceptionResponseDTO handleNotFoundInListError(BookNotFoundException exception){
        ExceptionResponseDTO error = new ExceptionResponseDTO(exception.getMessage(),"404");
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<ExceptionResponseDTO> handleInputError(MethodArgumentNotValidException exception) {
		
        List<ExceptionResponseDTO> erro = new ArrayList<>();

        List<FieldError> campoErro = exception.getBindingResult().getFieldErrors();

        campoErro.forEach(e -> {

            //String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());

            erro.add(new ExceptionResponseDTO(e.getField(), e.getDefaultMessage()));
        });
        return erro;

    }
}
