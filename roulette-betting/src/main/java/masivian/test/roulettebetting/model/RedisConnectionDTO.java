package masivian.test.roulettebetting.model;

/**
 * 
 * Clase encargada de almacenar los diferentes parametros de conexiones a Redis
 *
 * @author Indra Colombia<br>
 *         Diego Fernando Salinas Ramirez<br>
 *         Email: dfsalinas@indracompany.com<br>
 * 
 * @version 1.0, 30/03/2020
 *
 */
public class RedisConnectionDTO {

	/**
	 * Define url de conexion.
	 */
	private String host;

	/**
	 * Define url de conexion.
	 */
	private Integer port;

	/**
	 * Define la clave.
	 */
	private String password;

	/**
	 * Define el maximo del pool de conexiones.
	 */
	private Integer poolMaxTotal;

	/**
	 * Define el minimo del pool de conexiones.
	 */
	private Integer poolMaxIdle;

	/**
	 * Parametro de redis.
	 */
	private Integer poolMinIdle;

	/**
	 * Método que retorna el valor del atributo host
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @return host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Método que permite almacenar el valor host en el atributo host
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @param host el valor a asignar al atributo host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Método que retorna el valor del atributo port
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @return port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * Método que permite almacenar el valor port en el atributo port
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @param port el valor a asignar al atributo port
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * Método que retorna el valor del atributo password
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Método que permite almacenar el valor password en el atributo password
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @param password el valor a asignar al atributo password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Método que retorna el valor del atributo poolMaxTotal
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @return poolMaxTotal
	 */
	public Integer getPoolMaxTotal() {
		return poolMaxTotal;
	}

	/**
	 * Método que permite almacenar el valor poolMaxTotal en el atributo
	 * poolMaxTotal
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @param poolMaxTotal el valor a asignar al atributo poolMaxTotal
	 */
	public void setPoolMaxTotal(Integer poolMaxTotal) {
		this.poolMaxTotal = poolMaxTotal;
	}

	/**
	 * Método que retorna el valor del atributo poolMaxIdle
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @return poolMaxIdle
	 */
	public Integer getPoolMaxIdle() {
		return poolMaxIdle;
	}

	/**
	 * Método que permite almacenar el valor poolMaxIdle en el atributo poolMaxIdle
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @param poolMaxIdle el valor a asignar al atributo poolMaxIdle
	 */
	public void setPoolMaxIdle(Integer poolMaxIdle) {
		this.poolMaxIdle = poolMaxIdle;
	}

	/**
	 * Método que retorna el valor del atributo poolMinIdle
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @return poolMinIdle
	 */
	public Integer getPoolMinIdle() {
		return poolMinIdle;
	}

	/**
	 * Método que permite almacenar el valor poolMinIdle en el atributo poolMinIdle
	 * 
	 * @author Indra Colombia<br>
	 *         Diego Fernando Salinas Ramirez<br>
	 *         Email: dfsalinas@indracompany.com<br>
	 *
	 * @version 1.0, 30/03/2020
	 * 
	 * @param poolMinIdle el valor a asignar al atributo poolMinIdle
	 */
	public void setPoolMinIdle(Integer poolMinIdle) {
		this.poolMinIdle = poolMinIdle;
	}

}
