package org.charles.mutantDetector.business.mutantDetector.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.charles.mutantDetector.exceptions.InvalidDnaException;
import org.charles.mutantDetector.utils.DnaInputTestCaseInput;

public class DnaValidatorTest {

	@Test
	public void test_is_valid_with_invalid_dna() {
		DnaInputTestCaseInput invalidDna = DnaInputTestCaseInput.getInvalidDNA();
		DnaValidator dnaValidator = new DnaValidator();
		Assertions.assertThrows(InvalidDnaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				dnaValidator.validate(invalidDna.getDna());
			}
		}, "ADN INVALIDO");
	}

	@Test
	public void test_is_valid_with_valid_dna() {
		DnaInputTestCaseInput humanDna = DnaInputTestCaseInput.getHumanDNA();
		DnaValidator dnaValidator = new DnaValidator();
		String mensaje = "ADN VALIDO";
		try {
			Assertions.assertTrue(dnaValidator.validate(humanDna.getDna()), mensaje);
		} catch (InvalidDnaException e) {
			Assertions.fail(e);
		}
	}

}
