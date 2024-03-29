
package org.charles.mutantDetector.business.mutantDetector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.charles.mutantDetector.business.mutantDetector.impl.HorizontalRegexSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.HorizontalSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.InverseObliqueSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.ObliqueSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.VerticalSequenceDetectorImpl;
import org.charles.mutantDetector.utils.DnaInputTestCaseInput;

import lombok.extern.log4j.Log4j;

/**
 * TODO: Mejorar atomizando el test en los metodos que debe implementar
 * MutantSequenceDetector
 * 
 * @author JoseBautista
 *
 */
@Log4j
public class SequenceDetectorTest {

	/**
	 * ANALIZA CADENAS DE ADN VALIDAS EN BUSCA DE FALLAS EN LOS COMPONENTES DEL
	 * DETECTOR DE ADN HORIZONTAL
	 *
	 * @throws Exception
	 */
	@Test
	public void horizontalSequenceDetectorTest() throws Exception {
		SequenceDetector horizontalMsd = new HorizontalSequenceDetectorImpl(MutantDetector.MUTANT_SEQUENCE_LENGTH);
		DnaInputTestCaseInput dna = DnaInputTestCaseInput.getExhativeCaseMutantDNA();
		String message = "HORIZONTALES";
		genericMutantSequenceDetectorTest(horizontalMsd, message, dna.getHorizontalSequences(), dna.getDna());
	}
	
	@Test
	public void horizontalRegexSequenceDetectorTest() throws Exception {
		SequenceDetector horizontalMsd = new HorizontalRegexSequenceDetectorImpl(MutantDetector.MUTANT_SEQUENCE_LENGTH);
		DnaInputTestCaseInput dna = DnaInputTestCaseInput.getExhativeCaseMutantDNA();
		String message = "HORIZONTALES";
		genericMutantSequenceDetectorTest(horizontalMsd, message, dna.getHorizontalSequences(), dna.getDna());
	}

	/**
	 * ANALIZA CADENAS DE ADN VALIDAS EN BUSCA DE FALLAS EN LOS COMPONENTES DEL
	 * DETECTOR DE ADN VERTICAL
	 *
	 * @throws Exception
	 */
	@Test
	public void verticalSequenceDetectorTest() throws Exception {
		SequenceDetector horizontalMsd = new VerticalSequenceDetectorImpl(MutantDetector.MUTANT_SEQUENCE_LENGTH);
		DnaInputTestCaseInput dna = DnaInputTestCaseInput.getExhativeCaseMutantDNA();
		String message = "VERTICALES";
		genericMutantSequenceDetectorTest(horizontalMsd, message, dna.getVerticalSequences(), dna.getDna());
	}

	/**
	 * ANALIZA CADENAS DE ADN VALIDAS EN BUSCA DE FALLAS EN LOS COMPONENTES DEL
	 * DETECTOR DE ADN OBLICUOS
	 *
	 * @throws Exception
	 */
	@Test
	public void obliqueSequenceDetectorTest() throws Exception {
		SequenceDetector oblicqueMsd = new ObliqueSequenceDetectorImpl(MutantDetector.MUTANT_SEQUENCE_LENGTH);
		DnaInputTestCaseInput dna = DnaInputTestCaseInput.getExhativeCaseMutantDNA();
		String message = "OBLICUOS";
		genericMutantSequenceDetectorTest(oblicqueMsd, message, dna.getObliqueSequences(), dna.getDna());
	}

	/**
	 * ANALIZA CADENAS DE ADN VALIDAS EN BUSCA DE FALLAS EN LOS COMPONENTES DEL
	 * DETECTOR DE ADN OBLICUOS INVERSOS
	 *
	 * @throws Exception
	 */
	@Test
	public void inverseObliqueSequenceDetectorTest() throws Exception {
		SequenceDetector oblicqueMsd = new InverseObliqueSequenceDetectorImpl(MutantDetector.MUTANT_SEQUENCE_LENGTH);
		DnaInputTestCaseInput dna = DnaInputTestCaseInput.getExhativeCaseMutantDNA();
		String message = "OBLICUOS INVERSOS";
		genericMutantSequenceDetectorTest(oblicqueMsd, message, dna.getInverseObliqueSequences(), dna.getDna());
	}

	/**
	 * Pone a prueba los componentes del detector de secuencias mutantes testeando
	 * todo su correcto comportamiento La primer iteracion comprueba que el
	 * algoritmo se interrumpa al encontrar el resutlado minimo necesario. La
	 * segunda simplemente comprueba que el algoritmo encuentre todas las secuencias
	 * que haya.
	 * 
	 */
	private void genericMutantSequenceDetectorTest(SequenceDetector mutantSeqDetector, String tipoDetector, int expected, String[] dna) {
		try {
			String message = "Detector de Cantidad de secuencias " + tipoDetector;
			int[] maxNumbersOfSequence = { MutantDetector.N_SEQUENCES_TO_FIND, Integer.MAX_VALUE };
			for (int maxNumberOfSequence : maxNumbersOfSequence) {
				Assertions.assertEquals(Math.min(maxNumberOfSequence, expected), mutantSeqDetector.detect(dna, maxNumberOfSequence), message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(e);
		}
	}

	@Test
	/**
	 * TODO: Convertir en 2 test
	 */
	public void testIsMutant() {
		DnaInputTestCaseInput humanDna = DnaInputTestCaseInput.getHumanDNA();
		DnaInputTestCaseInput mutantDna = DnaInputTestCaseInput.getMutantDNA();
		MutantDetector mutantDetector = new MutantDetector();
		Assertions.assertFalse(mutantDetector.isMutant(humanDna.getDna()), "Es mutante");
		Assertions.assertTrue(mutantDetector.isMutant(mutantDna.getDna()), "Es mutante");
	}

	@Test
	@org.junit.Test
	/**
	 * imp ant: 3.349s x1M  matriz comun  de 6x6en Coni
	 * 
	 * 56.472s x1k matriz de 600x600
	 */
	public void isMutantSpeedTest() {
		String[] dna = DnaInputTestCaseInput.getHumanDNAInvalidOnlyForSpeedTest(100).getDna();
	
		Long start = System.currentTimeMillis();
		int iterations = 100;
		MutantDetector mutantDetector = new MutantDetector();
		for (int i = 0; i < iterations; i++) {
			mutantDetector.isMutant(dna);
		}
		Long finish = System.currentTimeMillis();
		log.info("Finish Speed test in" + (finish - start) + "ms");
	}
}
