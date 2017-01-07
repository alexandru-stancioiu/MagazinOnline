package ro.upb.cs.dai.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.upb.cs.dai.entities.User;
import ro.upb.cs.dai.model.CredentialsForm;

/**
 * Created by stancioi on 12/25/2016.
 */

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public void save(User user) {
        persist(user);
    }

    public User findByUsernameAndPassword(CredentialsForm credentialsForm) {

        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", credentialsForm.getUsername()));
        crit.add(Restrictions.eq("password", credentialsForm.getPassword()));
        User user = (User) crit.uniqueResult();
        return user;
    }
}
