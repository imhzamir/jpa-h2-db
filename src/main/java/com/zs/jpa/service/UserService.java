package com.zs.jpa.service;

import com.zs.jpa.bean.UserBean;
import com.zs.jpa.model.UserInfo;
import com.zs.jpa.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserInfoRepository repository;
    private ModelMapper modelMapper;

    public Page<UserBean> userList(Pageable pageable) {
        Page<UserInfo> page = repository.findAll(pageable);
        return new PageImpl<>(page.stream().map(this::getUserBean).toList(), page.getPageable(), page.getTotalElements());
    }

    public void save(UserBean userBean) {
        repository.save(getUserInfo(userBean));
    }

    private UserInfo getUserInfo(UserBean userBean) {
        return modelMapper.map(userBean, UserInfo.class);
    }

    private UserBean getUserBean(UserInfo userInfo) {
        return modelMapper.map(userInfo, UserBean.class);
    }
}
