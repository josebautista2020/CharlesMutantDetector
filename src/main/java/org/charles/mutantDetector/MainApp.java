package org.charles.mutantDetector;

import java.io.IOException;

import org.charles.mutantDetector.utils.ServersManager;

/**
 * Inicia la aplicación sin necesidad de deployarla ni tener activo un server de
 * Redis
 * 
 * @author JoseBautista
 *
 */
public class MainApp {

	public static void main(String[] args) throws IOException {
		ServersManager.StartServers(true);

	}

}
