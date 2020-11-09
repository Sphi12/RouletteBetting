
package masivian.test.roulettebetting.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import masivian.test.roulettebetting.model.RedisConnection;

@Configuration
public class RedisConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "masivian.connection.redis.roulette")
	public RedisConnection redisConnectionRoulette() {
		return new RedisConnection();
	}

//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix = "telefonica.connection.redis.charge.recurrent")
//	public RedisConnectionDTO redisConnectionChargeRecurrent() {
//		return new RedisConnectionDTO();
//	}

	JedisConnectionFactory jedisConnectionFactory(RedisConnection dataConnection) {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();

		if (dataConnection != null) {
			redisStandaloneConfiguration.setHostName(dataConnection.getHost());
			redisStandaloneConfiguration.setPort(dataConnection.getPort());

			if (dataConnection.getPassword() != null && !dataConnection.getPassword().isEmpty()) {
				redisStandaloneConfiguration.setPassword(dataConnection.getPassword());
			}

			JedisConnectionFactory connectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
			connectionFactory.getPoolConfig().setMaxTotal(dataConnection.getPoolMaxTotal());
			connectionFactory.getPoolConfig().setMaxIdle(dataConnection.getPoolMaxIdle());
			connectionFactory.getPoolConfig().setMinIdle(dataConnection.getPoolMinIdle());
			connectionFactory.getPoolConfig().setTestOnBorrow(true);
			connectionFactory.getPoolConfig().setTestOnReturn(true);
			return connectionFactory;
		}
		return new JedisConnectionFactory();
	}

//	@Bean("redisChargeRecurrent")
//	@Primary
//	RedisTemplate<String, Object> redisTemplateChargeRecurrent(
//			@Qualifier("redisConnectionChargeRecurrent") RedisConnectionDTO dataConnection) {
//		final RedisTemplate<String, Object> templateCharge = new RedisTemplate<>();
//		templateCharge.setConnectionFactory(jedisConnectionFactory(dataConnection));
//		templateCharge.setKeySerializer(new StringRedisSerializer());
//		templateCharge.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//		templateCharge.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//		templateCharge.setEnableTransactionSupport(true);
//		return templateCharge;
//	}

	@Bean("redisRoullete")
	RedisTemplate<String, Object> redisTemplateRoulette(
			@Qualifier("redisConnectionRoulette") RedisConnection dataConnection) {
		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory(dataConnection));
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setEnableTransactionSupport(true);
		return template;
	}

	@Bean("redisBet")
	RedisTemplate<String, Object> redisTemplateBet(
			@Qualifier("redisConnectionRoulette") RedisConnection dataConnection) {
		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory(dataConnection));
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setEnableTransactionSupport(true);
		return template;
	}

	@Bean("redisClient")
	RedisTemplate<String, Object> redisTemplateClient(
			@Qualifier("redisConnectionRoulette") RedisConnection dataConnection) {
		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory(dataConnection));
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setEnableTransactionSupport(true);
		return template;
	}

}
