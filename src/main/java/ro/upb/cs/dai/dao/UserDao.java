package ro.upb.cs.dai.dao;

import ro.upb.cs.dai.entities.User;
import ro.upb.cs.dai.model.CredentialsForm;

/**
 * Created by stancioi on 12/25/2016.
 */
public interface UserDao {

    void save(User user);

    User findByUsernameAndPassword(CredentialsForm credentialsForm);
}
