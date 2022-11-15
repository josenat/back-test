package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg230DestinatariosEmail;

public interface Tbasg230DestinatariosEmailRepository
		extends JpaRepository<Tbasg230DestinatariosEmail, String>, Tbasg230DestinatariosEmailRepositoryCustom {

	// Optional<Tbasg230DestinatariosEmail> findByDesgDireccionEmail(String
	// desgDireccionEmail);
	public Optional<Tbasg230DestinatariosEmail> findByDesgDireccionEmail(String desgDireccionEmail);

	public List<Tbasg230DestinatariosEmail> findByDesgDireccionEmailIn(Collection<String> desgDireccionEmail);
}
