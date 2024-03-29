package com.boot.boardbootproject.user.service;

import com.boot.boardbootproject.user.User;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.dto.UserUpdateNameForm;
import com.boot.boardbootproject.user.dto.UserUpdatePasswordForm;
import com.boot.boardbootproject.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class UserUpdateServiceTest {
    @Autowired
    private UserUpdateService userUpdateService;
    @Autowired
    private UserJoinService userJoinService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void updatePassword() throws Exception{
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemailb");
        form.setName("testnameb");
        form.setPassword("testpasswordb");

        Long id = userJoinService.join(form);

        UserUpdatePasswordForm form1 = new UserUpdatePasswordForm();
        form1.setId(id);
        form1.setPassword("newPassword");

        userUpdateService.updatePassword(form1);
        User user = userRepository.findById(id).get();

        assertThat(user.getPassword(), is(form1.getPassword()));
    }

    @Test
    void updateName() throws Exception{
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemailc");
        form.setName("testnamec");
        form.setPassword("testpasswordc");

        Long id = userJoinService.join(form);

        UserUpdateNameForm form1 = new UserUpdateNameForm();
        form1.setId(id);
        form1.setName("newName");

        userUpdateService.updateName(form1);
        User user = userRepository.findById(id).get();

        assertThat(user.getName(), is(form1.getName()));
    }

    @Test
    void update_fail_because_duplicate_name() throws Exception{
        UserJoinForm form = new UserJoinForm();
        form.setEmail("testemaild");
        form.setName("duplicate");
        form.setPassword("testpasswordd");

        Long id = userJoinService.join(form);

        UserJoinForm form1 = new UserJoinForm();
        form1.setEmail("testemaile11");
        form1.setName("oldName");
        form1.setPassword("testpassworddddd");

        Long id1 = userJoinService.join(form1);

        UserUpdateNameForm updateNameForm = new UserUpdateNameForm();
        updateNameForm.setId(id1);
        updateNameForm.setName("duplicate");

        try {
            userUpdateService.updateName(updateNameForm);
            fail();
        }catch (Exception e){

        }
    }
}