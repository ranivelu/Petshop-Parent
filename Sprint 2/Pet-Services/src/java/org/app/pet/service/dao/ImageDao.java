package org.app.pet.service.dao;

import org.app.pet.service.model.Image;
import javax.transaction.Transactional;

/**
 * Image implementation class
 * @author ravelu
 *
 */
@Transactional
public class ImageDao extends AbsHibernateDao<Image> implements IImageDao {

	public ImageDao(){
		super();
		setClassT(Image.class);
	}
}
