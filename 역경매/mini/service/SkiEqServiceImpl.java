package mini.service;

import java.util.List;

import mini.dao.SkiEqDao;
import mini.entity.SkiEquipment;

public class SkiEqServiceImpl implements SkiEqService {
	private SkiEqDao sDao = new SkiEqDao();

	@Override
	public List<SkiEquipment> listEquipment(int page, String field, String query) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		query = "%" + query + "%";
		List<SkiEquipment> list = sDao.getEquipmentList(COUNT_PER_PAGE, offset);
		return list;
	}

	@Override
	public SkiEquipment getEquipmentById(String equipmentId) {
		return sDao.getEquipmentById(equipmentId);
	}

	@Override
	public int countEquipment(String field, String query) {
		return sDao.countEquipment();
	}

	@Override
	public void addEquipment(SkiEquipment equipment) {
		sDao.insertEquipment(equipment);
	}

	@Override
	public void updateEquipment(SkiEquipment equipment) {
		sDao.updateEquipment(equipment);
	}

	@Override
	public void removeEquipment(String equipmentId) {
		sDao.deleteEquipment(equipmentId);
	}
}
