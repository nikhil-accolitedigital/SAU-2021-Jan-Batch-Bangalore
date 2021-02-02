

package com.au.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name = "rectangle")
	public Rectangle rectangle() {
		return new Rectangle();
	}

	@Bean(name = "P1")
	public Point pointAObj() {
		return new Point(0, 0);
	}

	@Bean(name = "P2")
	public Point pointBObj() {
		return new Point(20, 0);
	}

	@Bean(name = "P3")
	public Point pointCObj() {
		return new Point(20, 20);
	}

	@Bean(name = "P4")
	public Point pointDObj() {
		return new Point(0, 20);
	}
}