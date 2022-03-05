package com.one.FirstProject.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component

public class District {
	
	
	
	private int districtid;
	
	@Override
	public String toString() {
		return "District [district_id=" + districtid + ", district_name=" + districtname + "]";
	}

	public int getDistrict_id() {
		return districtid;
	}

	public void setDistrict_id(int district_id) {
		this.districtid = district_id;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrict_name(String district_name) {
		this.districtname = district_name;
	}

	private String districtname;
	


}
