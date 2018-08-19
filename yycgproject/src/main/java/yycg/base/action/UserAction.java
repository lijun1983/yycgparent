package yycg.base.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yycg.base.service.UserService;


@Controller
@RequestMapping("/user")
public class UserAction
{
	
	@Autowired
	private UserService userService;


	/**

	 *@描述  TODO: 用户管理 将页面所需要的数据取出，传到页面

	 *@参数  [model]

	 *@返回值  java.lang.String

	 *@创建人  lijun

	 *@创建时间  2018/8/19 0019

	 *@修改人和其它信息

	 */
	@RequestMapping("/queryuser")
	public String queryuser(Model model)throws Exception{
		return "/base/user/queryuser";
	}


}
