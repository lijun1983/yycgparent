package yycg.base.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.process.context.Config;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @Version : 1.0
 * @ClassName :本类名称 LogAction
 * @Auther : 创建人 Lijun
 * @Date : 创建时间 2018/8/22 0022 13:46
 * @Description: 描述 null
 * @TODO : 标注注释  用户认证 登陆
 * Created by IntelliJ IDEA
 */
@Controller
public class LogAction
{

  @Autowired
  UserService userService;

  @RequestMapping("/login")
  public String login(Model model)throws Exception{
    // 数据获取传到页面
    return "/base/login";
  }

  /**
   *@创建人  lijun
   *@创建时间  2018/8/22 0022 下午 2:26
   *@描述  用户登陆页面
   *@修改人和其它信息
   *@当前包名 yycg.base.action
   *@本类名称 LogAction
   *@参数  [session, userid, pwd, validateCode 验证码]
   *@对像函数方法体的封装 function
   * userService.checkUserInfo(userid, pwd)  登陆方法体
   * session.setAttribute(Config.ACTIVEUSER_KEY, activeUser);  将用户身份信息写入session
   *@返回值  yycg.base.process.result.SubmitResultInfo
   */
  @RequestMapping("/loginsubmit")
  public @ResponseBody SubmitResultInfo loginsubmit(HttpSession session, String userid, String pwd, String validateCode)throws Exception{

    //校验验证码
    String validateCode_session = (String) session.getAttribute("validateCode");
    if(validateCode_session!=null && !validateCode_session.equals(validateCode)){
      //验证码输入错误
      ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 113, null));
    }
    // service，用户认证
    ActiveUser activeUser = userService.checkUserInfo(userid, pwd);
    //System.out.println(activeUser.getUsername());

    // 将用户身份信息写入session
    session.setAttribute(Config.ACTIVEUSER_KEY, activeUser);

    return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 107, new Object[] { "" }));
  }
  //退出
  @RequestMapping("/logout")
  public String logout(HttpSession session)throws Exception{
    //session过期
    session.invalidate();
    return "redirect:login.action";
  }
}
