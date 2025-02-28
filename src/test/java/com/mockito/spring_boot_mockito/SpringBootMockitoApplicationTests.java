package com.mockito.spring_boot_mockito;

import com.mockito.spring_boot_mockito.dao.UserRepository;
import com.mockito.spring_boot_mockito.model.User;
import com.mockito.spring_boot_mockito.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class SpringBootMockitoApplicationTests {

    @Autowired
    private UserService service;
    @MockitoBean
    private UserRepository repository;

    @Test
    public void addUserTest() {
        User user = new User(10, "Abc", 24, "Bangalore");
        when(repository.save(user)).thenReturn(user);
        assertEquals(user, service.addUser(user));
    }

    @Test
    public void getUserTest() {
        List<User> userlist = Stream.of(new User(376, "Danile", 31, "USA"), new User(958, "Huy", 35, "UK")).toList();
        when(repository.findAll()).thenReturn(userlist);
        assertEquals(userlist, service.getUsers());
    }

    @Test
    public void getUserbyAddressTest() {
        List<User> userlist = Stream.of(new User(10, "Abc", 24, "Bangalore")).toList();
        when(repository.findByAddress("Bangalore")).thenReturn(userlist);
        assertEquals(1, service.getUserbyAddress("Bangalore").size());
    }

    @Test
    public void deleteUserTest() {
        User user = new User(10, "Abc", 24, "Bangalore");
        service.deleteUser(user);
        verify(repository, times(1)).delete(user);
    }

}
