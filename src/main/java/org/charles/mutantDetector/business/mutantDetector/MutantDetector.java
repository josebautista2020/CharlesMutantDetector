package org.charles.mutantDetector.business.mutantDetector;

import org.charles.mutantDetector.business.mutantDetector.impl.HorizontalRegexSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.HorizontalSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.InverseObliqueHorizontalSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.InverseObliqueVerticalSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.MultiDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.ObliqueHorizontalSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.ObliqueVerticalSequenceDetectorImpl;
import org.charles.mutantDetector.business.mutantDetector.impl.VerticalSequenceDetectorImpl;

/**
 * Clase que, compuesta de las otros detectores, ejecuta el algoritmo para
 * hallar una secuencia válida
 * 
 * @author JoseBautista
 *
 */
public class MutantDetector extends MultiDetectorImpl {
	final public static int N_SEQUENCES_TO_FIND = 2;
	final public static int MUTANT_SEQUENCE_LENGTH = 4;

	private MultiDetectorImpl multiSequenceDetectorImpl;

	public MutantDetector() {
		super();
		multiSequenceDetectorImpl = new MultiDetectorImpl();
		multiSequenceDetectorImpl.addDetector(new HorizontalSequenceDetectorImpl(MUTANT_SEQUENCE_LENGTH));
		//multiSequenceDetectorImpl.addDetector(new HorizontalRegexSequenceDetectorImpl(MUTANT_SEQUENCE_LENGTH));
		multiSequenceDetectorImpl.addDetector(new VerticalSequenceDetectorImpl(MUTANT_SEQUENCE_LENGTH));
		multiSequenceDetectorImpl.addDetector(new ObliqueHorizontalSequenceDetectorImpl(MUTANT_SEQUENCE_LENGTH));
		multiSequenceDetectorImpl.addDetector(new ObliqueVerticalSequenceDetectorImpl(MUTANT_SEQUENCE_LENGTH));
		multiSequenceDetectorImpl.addDetector(new InverseObliqueHorizontalSequenceDetectorImpl(MUTANT_SEQUENCE_LENGTH));
		multiSequenceDetectorImpl.addDetector(new InverseObliqueVerticalSequenceDetectorImpl(MUTANT_SEQUENCE_LENGTH));
	}

	public boolean isMutant(String[] dna) {
		return multiSequenceDetectorImpl.detect(dna, N_SEQUENCES_TO_FIND) == N_SEQUENCES_TO_FIND;
	}

}
