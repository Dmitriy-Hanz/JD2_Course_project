package repository;

import org.junit.*;
import org.junit.runners.MethodSorters;
import repository.dao.DaoFactory;
import repository.dao.idaos.EducationInfoDaoImpl;
import repository.dao.idaos.PersonDaoImpl;
import repository.entity.EducationInfo;
import repository.entity.Person;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EducationInfoDaoTest {
    private PersonDaoImpl personDao;
    private EducationInfoDaoImpl educationInfoDao;
    private static Person person;
    private static EducationInfo educationInfo;

    @Before
    public void preset(){
        personDao = DaoFactory.getInstance().createPersonDao();
        educationInfoDao = DaoFactory.getInstance().createEducationInfoDao();
    }
    @After
    public void postset(){
        personDao.closeDao();
        educationInfoDao.closeDao();
    }


    @Test
    public void t1_InsertTest()
    {
        educationInfo = EducationInfo.builder().lvlOfEducation(5).build();
        person = Person.builder().isForeign(false).educationInfo(educationInfo).build();

        personDao.insert(person);

        Person personFromDB = personDao.selectById(person.getId());

        assertNotNull(personFromDB);
        assertNotNull(personFromDB.getEducationInfo());
        assertEquals(person.getId(),personFromDB.getId());
        assertEquals(educationInfo.getId(),personFromDB.getEducationInfo().getId());
    }

    @Test
    public void t2_UpdateTest()
    {
        educationInfo.setLvlOfEducation(1);
        educationInfoDao.update(educationInfo);

        Person personFromDB = personDao.selectById(person.getId());

        assertNotNull(personFromDB);
        assertNotNull(personFromDB.getEducationInfo());
        assertEquals(person.getId(),personFromDB.getId());
        assertEquals(educationInfo.getLvlOfEducation(),personFromDB.getEducationInfo().getLvlOfEducation());
    }

    @Test
    public void t3_DeleteTest()
    {
        personDao.delete(person.getId());

        Person personFromDB = personDao.selectById(person.getId());
        EducationInfo educationInfoFromDB = educationInfoDao.selectById(educationInfo.getId());

        assertNull(personFromDB);
        assertNull(educationInfoFromDB);
    }
}
