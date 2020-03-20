import service.AdminService;
import service.impl.AdminServiceImpl;

public class Test {
    @org.junit.Test
    public void test(){
        AdminService adminService=new AdminServiceImpl();
        int count=adminService.login("admin","admin");
        if (count>0){
            System.out.println("登陆成功!");
        }else{
            System.out.println("登陆失败");
        }
    }
}
