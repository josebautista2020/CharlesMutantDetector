package org.charles.mutantDetector.services;

import org.jvnet.hk2.annotations.Contract;
import org.charles.mutantDetector.DTO.Stats;
import org.charles.mutantDetector.exceptions.DBException;

/**
 * Servicio de Estadísticas de los Análisis realizados
 * 
 * @author JoseBautista
 *
 */
@Contract
public interface StatsService {

	/**
	 * Devuelve las estadísticas de los análisis de ADN
	 * @return
	 * @throws DBException 
	 */
	public Stats getStats() throws DBException;
	/**
	 * Aumenta en 1 el contador de ADN mutante analizados
	 * @throws DBException 
	 */
	public void incrementMutantCount() throws DBException;
	
	/**
	 * Aumenta en 1 el contador de ADN Humanos analizados
	 * @throws DBException 
	 */
	public void incrementHumanCount() throws DBException;

}