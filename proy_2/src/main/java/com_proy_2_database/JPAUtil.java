package com_proy_2_database;

import jakarta.persistence.*;

public class JPAUtil {
	
	 private static EntityManagerFactory emf =
		        Persistence.createEntityManagerFactory("vehiculosPU");

		    public static EntityManagerFactory getEntityManagerFactory() {
		        return emf;
		    }

		    public static void close() {
		        emf.close();
		    }
}
