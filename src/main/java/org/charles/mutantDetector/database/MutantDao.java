package org.charles.mutantDetector.database;

import javax.inject.Singleton;

import org.jvnet.hk2.annotations.Service;
import org.charles.mutantDetector.database.jedis.JedisDao;
import org.charles.mutantDetector.database.jedis.JedisProducer;
import org.charles.mutantDetector.exceptions.DBException;

import com.fasterxml.jackson.core.JsonProcessingException;

import redis.clients.jedis.Jedis;

@Service
@Singleton
public class MutantDao extends JedisDao {

	public final String DAO_KEY = "mutant";

	@Override
	public String getDaoKey() {
		return DAO_KEY;
	}

	public MutantDao() {
	}

	/**
	 * Guarda en Redis la de ADN Mutante
	 * 
	 * @param dna
	 * @return True si se trata de una nueva de ADN. False si ya se encontraba
	 *         registrada
	 * @throws DBException
	 *             Error por falla al persistir o serializar
	 */
	public boolean saveMutantDna(String[] dna) throws DBException {
		Jedis jedis = null;
		try {
			jedis = JedisProducer.getInstance().get();

			Long added = jedis.sadd(getKey("mutant"), serialize(dna));
			return added == 1;
		} catch (JsonProcessingException e) {
			throw new DBException("Error mientras se intenta guardar el DNA", e);
		} finally {
			returnToPool(jedis);
		}
	}

}
