package org.charles.mutantDetector.services;

import org.jvnet.hk2.annotations.Contract;
import org.charles.mutantDetector.DTO.Dna;
import org.charles.mutantDetector.business.enums.EDnaType;
import org.charles.mutantDetector.exceptions.DBException;
import org.charles.mutantDetector.exceptions.InvalidDnaException;

@Contract
public interface MutantService {

	/**
	 * Analiza la cadena de de ADN en búsqueda del GEN Mutante
	 * 
	 * Asumo que recibo una cadena de ADN válida
	 * 
	 * @param dna
	 * @return true si la cadena es una cadena de ADN Mutante, sino false
	 * @throws DBException
	 *             Arrojada si ocurre algún error al querer registrar la cadena
	 * @throws InvalidDnaException
	 */
	public EDnaType analizeDna(Dna dna) throws DBException, InvalidDnaException;

}