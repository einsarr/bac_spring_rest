package com.isi.security;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("SELECT email as principal, password as credentials FROM user WHERE email =  ?")
			.authoritiesByUsernameQuery("SELECT users_email as principal, role_id as role FROM user_roles WHERE users_email = ?")
			.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin();//pour afficher un formulaire de connexion par defaut
		http.formLogin().loginPage("/login");//personnaliser le form de login
		//les droits dun USER
		http.authorizeRequests().antMatchers("/annees").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_SUPER");
		//les droits du role ETUDIANT
		http.authorizeRequests().antMatchers("/annees").hasAnyAuthority("ROLE_TECHNICIEN", "ROLE_ADMIN");
		//les droits du role PROFESSEUR
		http.authorizeRequests().antMatchers("/annees").hasAuthority("ROLE_TECHNICIEN");
		//gestion des droits
		http.exceptionHandling().accessDeniedPage("/403");
		http.csrf().disable();
	}

}