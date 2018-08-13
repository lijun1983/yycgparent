package yycg.base.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yycg.base.pojo.po.Sysuser;
import yycg.base.service.UserService;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
@Controller
public class FirsAction
{
  @Autowired
  private UserService userService;

  //1.TODO：首页ok
  @RequestMapping("/first")
  public String first(Model model)throws Exception{
    Sysuser sysuser = userService.findSysuserById("92");
    //将sysuser 传页面
    model.addAttribute("sysuser",sysuser);
    return "/base/first";
  }
   //2.TODO:欢迎页面（即首页右侧）
  @RequestMapping("/welcome")
  public String welcome()
  {
    return "/base/welcome";
  }
}
