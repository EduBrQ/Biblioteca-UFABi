package com.uepb.controlebiblioteca.service.impl;

import com.uepb.controlebiblioteca.model.UserRole;
import com.uepb.controlebiblioteca.service.UserRoleService;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public UserRole getRoleUser(String roleName) {
        return (UserRole) sessionFactory
                .getCurrentSession()
                .createCriteria(UserRole.class)
                .add(Restrictions.eq("roleName", roleName))
                .uniqueResult();
    }
}
