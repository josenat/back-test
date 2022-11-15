package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg125Empresa;

public interface Tbasg125EmpresaRepository
		extends JpaRepository<Tbasg125Empresa, Integer>, Tbasg125EmpresaRepositoryCustom {

	// Optional<Tbasg125Empresa> findByCdgoEmpresa(Integer cdgoEmpresa);
	public Optional<Tbasg125Empresa> findByCdgoEmpresa(Integer cdgoEmpresa);

	public List<Tbasg125Empresa> findByCdgoEmpresaIn(Collection<Integer> cdgoEmpresa);
}
