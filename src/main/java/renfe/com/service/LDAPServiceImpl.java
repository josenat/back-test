/**
 * 
 */
package renfe.com.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import renfe.com.dto.UserDTO;

/**
 * @author jrubiom
 *
 */

@Service
public class LDAPServiceImpl implements LDAPService {

	// Constantes env ldap
	private static final String CONTEXT_LDAP = "com.sun.jndi.ldap.LdapCtxFactory";
	private static final String AUTENTICATION_SIMPLE = "simple";
	private static final String SCOPE_RACFID = "##racfid##";

	// Constantes att ldap
	private static final String ATT_CN = "cn";
	private static final String ATT_CARLICENSE = "carlicense";
	
	@Value("${ldap.url}")
	private String ldapUrl;
	
	@Value("${ldap.principal}")
	private String ldapPrincipal;
	
	@Value("${ldap.search}")
	private String ldapSearch;
	
	@Value("${ldap.search.filter}")
	private String ldapSearchFilter;
	

	@Autowired
	protected Logger logger;

	@Override
	public boolean login(String strUser, String strPassword) {
		logger.debug("Inicio login usuario with profiles".concat(strUser).concat(" en LDAP."));
		boolean res = false;
		DirContext ctx = null;
		
		try {
			// Datos del RDA
			Hashtable<String, String> env = configureLdapProps(strUser, strPassword);
			// Creamos el contexto inicial
			ctx = new InitialDirContext(env);
			// Instanciamos el objeto
			res= true;
			// Obtenemos mas datos de usaurio de LDAP si existieran
			//extractUserData(strUser, userDto, ctx);
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
			res = false;
		}
		logger.debug("FIN Buscar datos usuario en RDA.");
		return res;
	}

	private void extractUserData(String strUser, UserDTO userDto, DirContext ctx) throws NamingException {
		// Obtengo solo ciertos atributos para el usuario
		SearchControls ctls = new SearchControls();
		ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		
		// Search for objects using filter and controls
		NamingEnumeration<SearchResult> enumeration = ctx.search(ldapSearch,
				ldapSearchFilter.replace(SCOPE_RACFID, strUser.toUpperCase()), ctls);
		
		// Recorremos los resultados obtenidos
		if (enumeration.hasMore()) {
			while (enumeration.hasMore()) {
				SearchResult result = (SearchResult) enumeration.next();
				Attributes attr = result.getAttributes();
				userDto.setDesgUsuario((String) attr.get(ATT_CN).get());
				userDto.setCdgoMatricula((String) attr.get(ATT_CARLICENSE).get());
			} // fin While
		}
	}

	private Hashtable<String, String> configureLdapProps(String strUser, String strPassword) {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, CONTEXT_LDAP);
		env.put(Context.SECURITY_AUTHENTICATION, AUTENTICATION_SIMPLE);
		env.put(Context.PROVIDER_URL, ldapUrl);
		env.put(Context.SECURITY_PRINCIPAL, ldapPrincipal.replace(SCOPE_RACFID, strUser.toUpperCase()));
		env.put(Context.SECURITY_CREDENTIALS, strPassword);
		return env;
	}

	static void printAttrs(Attributes attrs) {
		if (attrs == null) {
			System.out.println("No attributes");
		} else {
			/* Print each attribute */
			try {
				for (NamingEnumeration ae = attrs.getAll(); ae.hasMore();) {
					Attribute attr = (Attribute) ae.next();
					System.out.println("attribute: " + attr.getID());

					/* print each value */
					for (NamingEnumeration e = attr.getAll(); e.hasMore(); System.out.println("value: " + e.next()))
						;
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}
}
// end class RDAServiceImpl
