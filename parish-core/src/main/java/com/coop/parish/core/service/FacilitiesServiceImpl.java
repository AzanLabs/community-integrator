package com.coop.parish.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.coop.parish.data.modal.Audit;
import com.coop.parish.data.modal.Church;
import com.coop.parish.data.modal.Facilities;
import com.coop.parish.data.modal.Image;

public class FacilitiesServiceImpl extends BaseServiceImpl implements FacilitiesService{

	public FacilitiesServiceImpl(EntityManager em) {
		super(em);
	}
	
	public void saveFacility() {
		Audit audit = new Audit();
		audit.setCreatedBy(1001);
		audit.setCreatedOn(new Date());
		audit.setLastModifiedBy(1001);
		audit.setLastModifiedOn(new Date());
		
		List<Image> imgs = new ArrayList<Image>();
		int i = 0;
		while(++i < 5){
			Image img = new Image();
			img.setImageName("1001.jpg");
			img.setImageType("jpg");
			img.setSize(200);
			img.setEntity("FOLDER");
			img.setImageGroupId(1);
			img.setAudit(audit);
			img.setActive(true);
		}
		
		Facilities f = new Facilities();
		f.setName("marriage hall");
		f.setUsedFor("marriage");
		f.setFeatures("qw ee r r ");
		f.setCanBeBooked(true);
		f.setActive(true);
		f.setImageGroupId(1);
		
		f.setImages(imgs);
		f.setChurch(new Church(2001));
		f.setAudit(audit);
		em.persist(f);
	}

}
