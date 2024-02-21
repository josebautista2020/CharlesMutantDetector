package org.charles.mutantDetector.services;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.charles.mutantDetector.DTO.Dna;
import org.charles.mutantDetector.business.enums.EDnaType;
import org.charles.mutantDetector.database.MutantDao;
import org.charles.mutantDetector.database.StatsDao;
import org.charles.mutantDetector.exceptions.DBException;
import org.charles.mutantDetector.exceptions.InvalidDnaException;
import org.charles.mutantDetector.services.impl.MutantServiceImpl;
import org.charles.mutantDetector.services.impl.StatsServiceImpl;
import org.charles.mutantDetector.utils.DnaInputTestCaseInput;
import org.charles.mutantDetector.utils.TestWithNewRedisServerInstance;

@TestInstance(Lifecycle.PER_CLASS)
public class MutantServiceTest extends TestWithNewRedisServerInstance {

	List<DnaInputTestCaseInput> dnaTestCases;

	@BeforeAll
	public void setup() {
		super.setup();
	}

	@AfterAll
	public void finish() {
		super.finish();
	}

	@Test
	/**
	 * TODO: Agregar Mock para solamente testear analizeDNA
	 */
	public void analizeDnaTest() {
		List<DnaInputTestCaseInput> dnas = DnaInputTestCaseInput.getAllTestMatrices();
		MutantService service = instantiateMuntantService();
		for (DnaInputTestCaseInput dnaStruct : dnas) {
			Dna dna = new Dna();
			dna.setDna(dnaStruct.getDna());
			try {
				Assertions.assertEquals((dnaStruct.isMutant() ? EDnaType.MUTANT : EDnaType.HUMAN), service.analizeDna(dna));
			} catch (DBException e) {
				Assertions.fail(e);
			} catch (InvalidDnaException e) {
				Assertions.assertFalse(dnaStruct.isValid());
			}
		}
	}

	private MutantService instantiateMuntantService() {

		return new MutantServiceImpl(new MutantDao(), new StatsServiceImpl(new StatsDao()));
	}

}