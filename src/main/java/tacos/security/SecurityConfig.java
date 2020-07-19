package tacos.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());

//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(-1);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/design", "/orders")
		.anonymous()
//		.hasRole("USER")
		.antMatchers("/", "/**")
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/design", true)
		.and()
		.logout()
		.logoutSuccessUrl("/");			//true to force user to navigate to design page after login
	}
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)
//	throws Exception {
//		auth
//		.inMemoryAuthentication()
//		.withUser("buzz")
//		.password("infinity")
//		.authorities("ROLE_USER")
//		.and()
//		.withUser("woody")
//		.password("bullseye")
//		.authorities("ROLE_USER");
//	}
}
