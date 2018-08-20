package yycg.base.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yycg.base.pojo.process.result.DataGridResultInfo;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.service.UserService;

import java.util.List;


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

	 *@修改人和其它信息  用户管理 模块

	 */
	@RequestMapping("/queryuser")
	public String queryuser(Model model)throws Exception{
		return "/base/user/queryuser";
	}

	/**

	 *@描述

	 *@参数  [sysuserQueryVo, page 页码, rows 每页显示个数]

	 *@返回值  yycg.base.pojo.process.result.DataGridResultInfo

	 *@创建人  lijun

	 *@创建时间  2018/8/20 0020

	 *@修改人和其它信息

	 */

	@RequestMapping("/queryuser_result")
	public @ResponseBody DataGridResultInfo queryuser_result(SysuserQueryVo sysuserQueryVo, int page, int rows)throws Exception{


		//非空校验
		sysuserQueryVo = sysuserQueryVo!=null?sysuserQueryVo:new SysuserQueryVo();

		//查询列表的总数(统计)
		int total = userService.findSysuserCount(sysuserQueryVo);

		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(total, rows, page);//格式化数据

		sysuserQueryVo.setPageQuery(pageQuery);

		//分页列表查询，向sysuserQueryVo中传入    格式化数据 pageQuery
		List<SysuserCustom> list = userService.findSysuserList(sysuserQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		//填充 total
		dataGridResultInfo.setTotal(total);
		//填充  rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

}
