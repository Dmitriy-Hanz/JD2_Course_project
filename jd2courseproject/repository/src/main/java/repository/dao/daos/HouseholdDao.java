package repository.dao.daos;

import repository.dao.daos.base.Dao;
import repository.dao.idaos.HouseholdDaoImpl;
import repository.entity.Household;

import javax.persistence.EntityManager;

public class HouseholdDao extends Dao<Household> implements HouseholdDaoImpl {

    public HouseholdDao(EntityManager em) {
        super(em, Household.class);
    }
}
