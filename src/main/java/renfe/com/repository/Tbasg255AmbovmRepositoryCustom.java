package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg255Ambovm;

public interface Tbasg255AmbovmRepositoryCustom {

	public List<Tbasg255Ambovm> getAmbitosOVMCount();

	public List<Tbasg255Ambovm> getAmbitosOVMListAscendente();

	public List<Tbasg255Ambovm> getAmbitosOVMListDescendente();

	public List<Tbasg255Ambovm> getAmbitosOVMActiveList();

	public List<Tbasg255Ambovm> getAmbitosOVM(String cdgoAmbovm);

	public int insertAmbitosOVM(Tbasg255Ambovm bean);

	public int updateAmbitosOVM(Tbasg255Ambovm bean);

	public int deleteAmbitosOVM(Tbasg255Ambovm bean);

}
