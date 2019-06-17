package info.mintymods.mss.webapp.form;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class FormValidationTestBase {
	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	@BeforeClass
	public static void beforeClass() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@AfterClass
	public static void afterClass() {
		validatorFactory.close();
	}

	protected void assertViolation(Set<ConstraintViolation> constraintViolations, String message, String propertyPath,
			String invalidValue) {
		ConstraintViolation violation = constraintViolations.iterator().next();
		assertThat("Unexpected message.", violation.getMessage(), is(message));
		assertThat("Unexpected property.", violation.getPropertyPath().toString(), is(propertyPath));
		assertThat("Unexpected invalid value.", violation.getInvalidValue(), is(invalidValue));
	}
}
