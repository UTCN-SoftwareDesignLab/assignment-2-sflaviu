package bookstore.service.user;

import bookstore.dto.UserDTO;
import bookstore.entity.User;
import bookstore.repository.UserRepository;
import bookstore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,ShaPasswordEncoder shaPasswordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=shaPasswordEncoder;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        User user=new User(userDTO.username,passwordEncoder.encodePassword(userDTO.password,null),"EMPLOYEE");
        return userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        userRepository.delete(username);
    }

    @Override
    public User update(UserDTO userDTO) {
        User user=userRepository.findOne(userDTO.username);
        user.setPassword(passwordEncoder.encodePassword(userDTO.password,null));
        return userRepository.save(user);

    }

}
