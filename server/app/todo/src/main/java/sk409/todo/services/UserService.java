package sk409.todo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk409.todo.Authority;
import sk409.todo.models.User;
import sk409.todo.repositories.UserRepository;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final TodoCategoryService todoCategoryService;
    private final TodoStatusService todoStatusService;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, TodoCategoryService todoCategoryService,
            TodoStatusService todoStatusService, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.todoCategoryService = todoCategoryService;
        this.todoStatusService = todoStatusService;
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        final Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }
    
    public User registerUser(String username, String password, String email) {
        final User user = new User(username, passwordEncoder.encode(password), email);
        userRepository.save(user);
        final List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(Authority.ROLE_USER.toString()));
        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),
                user.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(token);
        todoCategoryService.save("緊急", "早急に取り組むべき課題です", user.getId());
        todoStatusService.save("未対応", user.getId());
        return user;
    }

}