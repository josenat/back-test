
package renfe.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${application.tokenkey}")
	private String tokenkey;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		JWTAuthorizationFilter JWTauth = new JWTAuthorizationFilter();
		JWTauth.setSecret(tokenkey);
		http.csrf().disable().cors().and()
				.addFilterAfter(JWTauth, UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers(HttpMethod.POST, "/asg/api/user/login").permitAll()
				.antMatchers("/actuator/**").permitAll().anyRequest().authenticated();

	}

}
