package org.charles.mutantDetector.business.mutantDetector;

/**
 * API del Detector de secuencias mutante
 * @author JoseBautista 
 *
 */
public interface SequenceDetector {

	/**
	 * Método que se ejecuta para buscar y contar secuencias hasta maxNumberOfSequencesTryingToDetect
	 * 
	 * @param dna
	 * @param maxNumberOfSequencesToTryDetect
	 * @return
	 */
	public int detect(String[] dna, int maxNumberOfSequencesTryingToDetect);
	
}
