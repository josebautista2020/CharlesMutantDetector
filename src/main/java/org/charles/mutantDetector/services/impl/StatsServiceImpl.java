package org.charles.mutantDetector.services.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jvnet.hk2.annotations.Service;
import org.charles.mutantDetector.DTO.Stats;
import org.charles.mutantDetector.database.StatsDao;
import org.charles.mutantDetector.exceptions.DBException;
import org.charles.mutantDetector.services.StatsService;

@Service
@Singleton
public class StatsServiceImpl implements StatsService {

	@Inject
	private StatsDao statsDao;

	public StatsServiceImpl() {
	}
	
	public StatsServiceImpl(StatsDao statsDao) {
		super();
		this.statsDao = statsDao;
	}

	public Stats getStats() throws DBException {
		return statsDao.getStats();
	}

	@Override
	public void incrementMutantCount() throws DBException {
		statsDao.addMutant();
		
	}

	@Override
	public void incrementHumanCount() throws DBException {
		// TODO Auto-generated method stub
		statsDao.addHuman();
	}

}