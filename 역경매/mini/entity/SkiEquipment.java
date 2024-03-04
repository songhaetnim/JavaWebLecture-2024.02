package mini.entity;

public class SkiEquipment {
	private String equipmentId;
	private String userId;
	private String equipmentName;
	private String description;
	private String condition;
	private String imageUrl;

	public SkiEquipment(String equipmentId, String userId, String description, String condition, String imageUrl) {
		this.equipmentId = equipmentId;
		this.userId = userId;
		this.description = description;
		this.condition = condition;
		this.imageUrl = imageUrl;
	}
	// 기본 생성자
	public SkiEquipment() { }
	public SkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
			String condition, String image_url) {
		this.equipmentId = equipment_id;
		this.userId = user_id;
		this.equipmentName = equipment_name;
		this.description = description;
		this.condition = condition;
		this.imageUrl = image_url;
	}

	// 스키 장비 선택 생성자
	public SkiEquipment(String equipment_id, String equipment_name) {
		this.equipmentId = equipment_id;
		this.equipmentName = equipment_name;
	}

	// 스키 장비 생김새/설명 및 내구성 생성자
	public SkiEquipment(String description, String condition, String image_url) {
		this.description = description;
		this.condition = condition;
		this.imageUrl = image_url;
	}

	// 대여한걸 수정하고 싶을 때 확인할 생성자
	public SkiEquipment(String user_id) {
		this.userId = user_id;
	}

	@Override
	public String toString() {
		return "SkiEquipment [equipmentId=" + equipmentId + ", userId=" + userId + ", equipmentName=" + equipmentName
				+ ", description=" + description + ", condition=" + condition + ", imageUrl=" + imageUrl + "]";
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
