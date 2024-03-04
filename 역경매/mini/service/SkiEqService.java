package mini.service;

import java.util.List;

import mini.entity.SkiEquipment;

public interface SkiEqService {
	public static final int COUNT_PER_PAGE = 10;
	
	    List<SkiEquipment> listEquipment(int page, String field, String query);

	    SkiEquipment getEquipmentById(String equipmentId);

	    int countEquipment(String field, String query);

	    void addEquipment(SkiEquipment equipment);

	    void updateEquipment(SkiEquipment equipment);

	    void removeEquipment(String equipmentId);
	    
	}

