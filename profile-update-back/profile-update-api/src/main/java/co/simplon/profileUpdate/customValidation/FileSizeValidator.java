package co.simplon.profileUpdate.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileSizeValidator
	implements ConstraintValidator<FileSize, MultipartFile> {

    private static final Integer FILE_SIZE = 1024 * 1024;

    @Override
    public boolean isValid(MultipartFile value,
	    final ConstraintValidatorContext context) {

	if (value == null) {
	    return true;
	}

	if (FILE_SIZE > value.getSize()) {
	    return true;
	}

	return false;
    }

}
