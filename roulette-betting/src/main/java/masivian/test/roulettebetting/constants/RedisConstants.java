
package masivian.test.roulettebetting.constants;

public final class RedisConstants {

	public static final String HASH_ROULETTES = "ROULETTES";
	public static final String HASH_CLIENTS = "CLIENTS";
	public static final String HASH_BETS = "BETS";
	
	/**
	 * Clave hash para el almacenamiento de los productos en redis
	 */
	public static final String HASH_PRODUCTS = "OTC_T_CHARGEPRODUCT";

	/**
	 * Determina el nombre del servicio a loggear
	 */
	public static final String SERVICE_NAME = "ProductsCacheInstance";
	

	/**
	 * Determina el nombre del servicio a loggear
	 */
	public static final String SERVICE_NAME_BALANCE = "ShowBalanceController";

	/**
	 * Determina el nombre de la operación getProductCache a loggear
	 */
	public static final String OPERATION_NAME_INSTANCE = "loadProductCache";

	
	
	/**
	 * Determina el nombre de la operación getProductCache a loggear
	 */
	public static final String OPERATION_NAME_INSTANCE_BALANCE = "loadBalancesCache";
	/**
	 * Determina el nombre de la operación getProductCacheById a loggear
	 */
	public static final String OPERATION_NAME_INSTANCES = "getProductCacheById";

	/**
	 * Nombre del dto a validar en la respuesta.
	 */
	public static final String RESPONSE_PRODUCT_DTO_NAME = "ProductChargeResponseDTO";

	/**
	 * Error en la validacion del product Id en la peticion.
	 */
	public static final String CAUSE_ERROR_ID_VALIDATION = "El parámetro id es requerido";

	/**
	 * Mensaje de confirmación para la carga de productos en cache redis
	 */
	public static final String MESSAGE_LOAD_PRODUCTS = "Productos almacenados exitosamente en caché";

	/**
	 * Mensaje para cuando no se encuentra un producto
	 */
	public static final String MESSAGE_PRODUCT_NOT_FOUND = "Producto no encontrado";

	/**
	 * Mensaje de confirmación
	 */
	public static final String CONFIRMATION_OK = "OK";

	/**
	 * Varible que representa la cadena
	 */
	public static final String UNEXPECTED_ERROR_VALUES_ENTERED = "Error inesperado con los valores ingresados ";

	/**
	 * Clave hash para el almacenamiento de los Bonos de configuracion Altamira en
	 * redis
	 */
	public static final String HASH_BONUSES = "OTC_T_BONOS_ALTAMIRA";
	
	/**
	 * Clave hash para el almacenamiento de las configuraciones de saldos de configuracion Altamira en
	 * redis
	 */
	public static final String HASH_BALANCES = "OTC_T_MANAGEBALANCE_CONF";

	/**
	 * Determina el nombre del servicio BonusDetail a loggear
	 */
	public static final String SERVICE_NAME_BONUS_DETAIL = "BonusDetailController";
	
	/**
	 * Determina el nombre del servicio showBalance a loggear
	 */
	public static final String SERVICE_NAME_SHOW_BALANCE = "ShowBalanceController";

	/**
	 * Determina el nombre de la operación loadBonusesInCache a loggear
	 */
	public static final String OPERATION_NAME_LOAD_BONUSES = "loadBonusesInCache";
	
	/**
	 * Determina el nombre de la operación loadBalanceInCache a loggear
	 */
	public static final String OPERATION_NAME_LOAD_BALANCES = "loadBalanceInCache";

	/**
	 * Determina el nombre de la operación queryBonusDetailLoad a loggear
	 */
	public static final String OPERATION_NAME_QBDL = "queryBonusDetailById";

	/**
	 * Determina el nombre de la operación showBalanceById a loggear
	 */
	public static final String OPERATION_NAME_SHOW_BALANCE_BY_ID = "showBalanceById";
	
	/**
	 * Nombre del dto de queryBonusDetail a validar en la respuesta.
	 */
	public static final String RESPONSE_QUERY_BONUS_DETAIL_DTO_NAME = "QueryBonusDetailPullResponseDTO";
	
	/**
	 * Nombre del dto de ShowBalance a validar en la respuesta.
	 */
	public static final String RESPONSE_SHOW_BALANCE_DTO_NAME = "ShowBalancePullResponseDTO";

	/**
	 * Constructor de la clase.
	 */
	private RedisConstants() {
		super();
	}

}
