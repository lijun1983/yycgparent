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


  /**

   *@描述 1.首页ok

   *@参数  [model]

   *@返回值  java.lang.String

   *@创建人  lijun

   *@创建时间  2018/8/18 0018

   *@修改人和其它信息
   */
  //TODO:
  @RequestMapping("/first")
  public String first(Model model)throws Exception{

    Sysuser sysuser = userService.findSysuserById("92");
    //将sysuser 传页面
    model.addAttribute("sysuser",sysuser);
    return "/base/first";
  }

  /**

   *@描述 2.TODO:欢迎页面（即首页右侧）

   *@参数  []

   *@返回值  java.lang.String

   *@创建人  lijun

   *@创建时间  2018/8/18 0018

   *@修改人和其它信息

   */
  @RequestMapping("/welcome")
  public String welcome()
  {
    return "/base/welcome";
  }
}
