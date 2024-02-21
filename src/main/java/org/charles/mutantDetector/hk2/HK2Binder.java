package org.charles.mutantDetector.hk2;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.charles.mutantDetector.database.MutantDao;
import org.charles.mutantDetector.database.StatsDao;
import org.charles.mutantDetector.services.MutantService;
import org.charles.mutantDetector.services.StatsService;
import org.charles.mutantDetector.services.impl.MutantServiceImpl;
import org.charles.mutantDetector.services.impl.StatsServiceImpl;

public class HK2Binder extends AbstractBinder {

	public HK2Binder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * TODO: Implementar ServiceLocator para bind automático con Annotation
	 */
	@Override
	protected void configure() {
		bind(StatsServiceImpl.class).to(StatsService.class);
		bind(MutantServiceImpl.class).to(MutantService.class);
		bind(MutantDao.class).to(MutantDao.class);
		bind(StatsDao.class).to(StatsDao.class);
	}
}
