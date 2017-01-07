package ro.upb.cs.dai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.cs.dai.dao.UserDao;
import ro.upb.cs.dai.entities.User;
import ro.upb.cs.dai.model.CredentialsForm;

/**
 * Created by stancioi on 12/25/2016.
 */

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public User login(CredentialsForm credentialsForm) {
        User user = userDao.findByUsernameAndPassword(credentialsForm);

        return user;
    }
}
