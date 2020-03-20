package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

    @Override
    public int login(String name, String pwd) {
        AdminDao adminDao=new AdminDaoImpl();
        int count = adminDao.login(name, pwd);
        return count;
    }
}
