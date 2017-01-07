package ro.upb.cs.dai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.cs.dai.dao.UserDao;
import ro.upb.cs.dai.model.CredentialsForm;
import ro.upb.cs.dai.entities.Role;
import ro.upb.cs.dai.entities.User;

/**
 * Created by stancioi on 12/25/2016.
 */

@Service
public class RegisterService {

    @Autowired
    private UserDao userDao;

    public void register(CredentialsForm credentialsForm) {

        User user = new User(credentialsForm.getUsername(), credentialsForm.getPassword());
        user.setRole(Role.USER);
        userDao.save(user);
    }
}
