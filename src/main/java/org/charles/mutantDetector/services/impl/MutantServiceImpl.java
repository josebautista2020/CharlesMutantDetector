package org.charles.mutantDetector.services.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jvnet.hk2.annotations.Service;
import org.charles.mutantDetector.DTO.Dna;
import org.charles.mutantDetector.business.enums.EDnaType;
import org.charles.mutantDetector.business.mutantDetector.MutantDetector;
import org.charles.mutantDetector.business.mutantDetector.validator.DnaValidator;
import org.charles.mutantDetector.database.MutantDao;
import org.charles.mutantDetector.exceptions.DBException;
import org.charles.mutantDetector.exceptions.InvalidDnaException;
import org.charles.mutantDetector.services.MutantService;
import org.charles.mutantDetector.services.StatsService;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
@Singleton
public class MutantServiceImpl implements MutantService {

	@Inject
	private MutantDao dnaDao;
	@Inject
	private StatsService statsService;

	public MutantServiceImpl() {
		super();

	}

	public MutantServiceImpl(MutantDao dnaDao, StatsServiceImpl statsService) {
		this();
		this.dnaDao = dnaDao;
		this.statsService = statsService;
	}

	@Override
	public EDnaType analizeDna(Dna dnaData) throws DBException, InvalidDnaException {
		String[] dna = dnaData.getDna();
		DnaValidator dnaValidator = new DnaValidator();
		dnaValidator.validate(dna);
		MutantDetector mutantDetector = new MutantDetector();
		boolean isMutant = mutantDetector.isMutant(dna);
		EDnaType type;
		if (isMutant) {
			type = EDnaType.MUTANT;
			registerMutantDna(dna);
		} else {
			type = EDnaType.HUMAN;
			registerHuman();
		}

		return type;
	}

	public void registerMutantDna(String[] dna) throws DBException {
		if (dnaDao.saveMutantDna(dna)) {
			log.debug("Registrando un nuevo DNA mutante");
		} else {
			log.debug("el DNA mutante ya ha sido registrado");
		}
		statsService.incrementMutantCount();
	}

	public void registerHuman() throws DBException {
		log.debug("Descartando DNA humano");
		statsService.incrementHumanCount();
	}

}