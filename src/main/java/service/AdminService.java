package service;

public interface AdminService {
    /**
     * 登陆
     *
     * @param name
     * @param pwd
     * @return
     */
    public int login(String name, String pwd);
}
