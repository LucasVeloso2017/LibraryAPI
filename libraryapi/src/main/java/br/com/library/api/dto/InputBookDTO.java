package br.com.library.api.dto;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InputBookDTO {

    @NotNull 
	@NotEmpty
    private String title;

    @NotNull
	@NotEmpty
    private String publisher;

    @NotNull
	@NotEmpty
    private String photo;

    @NotNull
	@NotEmpty
    private String author;

}
