package org.charles.mutantDetector.database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.charles.mutantDetector.exceptions.DBException;
import org.charles.mutantDetector.utils.DnaInputTestCaseInput;
import org.charles.mutantDetector.utils.TestWithNewRedisServerInstance;

public class MutantDaoTest extends TestWithNewRedisServerInstance {

	@BeforeAll
	public void setup() {
		super.setup();
	}

	@AfterAll
	public void finish() {
		super.finish();
	}

	@Test
	public void saveMutantDnaTest() {
		DnaInputTestCaseInput it = DnaInputTestCaseInput.getMutantDNA();
		MutantDao mutantDao;
		mutantDao = new MutantDao();
		try {
			Assertions.assertTrue(mutantDao.saveMutantDna(it.getDna()), () -> "Se registro una nueva cadena");
			Assertions.assertFalse(mutantDao.saveMutantDna(it.getDna()), () -> "Se registro nuevammente la misma cadena");
		} catch (DBException e) {
			Assertions.fail(e);
		}
	}

}