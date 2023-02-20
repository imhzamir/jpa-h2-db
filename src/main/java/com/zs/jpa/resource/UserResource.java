package com.zs.jpa.resource;

import com.zs.jpa.bean.UserBean;
import com.zs.jpa.model.UserInfo;
import com.zs.jpa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserResource {

    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserBean>> getUserList(Pageable pageable) {
        return ResponseEntity.ok(service.userList(pageable));
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody @Validated UserBean userBean) {
        service.save(userBean);
        return ResponseEntity.noContent().build();
    }

}
