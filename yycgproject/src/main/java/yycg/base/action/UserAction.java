package yycg.base.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.process.context.Config;
import yycg.base.process.result.DataGridResultInfo;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserAction
{
	
	@Autowired
	private UserService userService;

	/**
	 *@创建人  lijun
	 *@创建时间  2018/8/21 0021 下午 7:04
	 *@描述 TODO: 用户管理 将页面所需要的数据取出，传到页面  绑定 jsp 静态页面的   添加用户页面 TODO:弹层
	 *@修改人和其它信息  用户管理 模块
	 *@当前包名 yycg.base.action
	 *@本类名称 UserAction
	 *@参数  [model]
	 *@对像函数方法体的封装 function
	 *@返回值  java.lang.String
	 */
	@RequestMapping("/queryuser")
	public String queryuser(Model model)throws Exception{

		//int i = 1/0;   //测试未知错误异常
		return "/base/user/queryuser";
	}


	/**
	 *@创建人  lijun
	 *@创建时间  2018/8/21 0021 下午 7:03
	 *@描述   绑定 json 数据的
	 *@修改人和其它信息
	 *@当前包名 yycg.base.action
	 *@本类名称 UserAction
	 *@参数  [sysuserQueryVo 包装类 , page, rows]
	 *@对像函数方法体的封装 function
	 *@返回值  yycg.base.process.result.DataGridResultInfo
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

	
	/**
	 *@创建人  lijun
	 *@创建时间  2018/8/21 0021 下午 7:02
	 *@描述   绑定 jsp 静态页面的   添加用户页面 TODO:弹层
	 *@修改人和其它信息
	 *@当前包名 yycg.base.action
	 *@本类名称 UserAction
	 *@参数  [model]
	 *@对像函数方法体的封装 function
	 *@返回值  java.lang.String
	 */
	@RequestMapping("/addsysuser")
	public String addsysuser(Model model)throws Exception{

		return "/base/user/addsysuser";
	}

	/**
	 *@创建人  lijun
	 *@创建时间  2018/8/21 0021 下午 7:00
	 *@描述
	 *@修改人和其它信息
	 *@当前包名 yycg.base.action
	 *@本类名称 UserAction
	 *@参数  [sysuserQueryVo] 包装类
	 *@对像函数方法体的封装 function
	 * ResultUtil.createSubmitResult();
	 * createSubmitResult（） yycg/base/process/result/ResultUtil.java:97 查看
	 * ResultUtil.createSuccess(Config.MESSAGE, 906, null)  yycg/base/process/result/ResultUtil.java:48 查看
	 * Config.MESSAGE yycg/base/process/context/Config.java:30 查看
	 * 906  resources/messages.properties:7   中查看
	 *@返回值  yycg.base.process.result.SubmitResultInfo
	 */
	@RequestMapping("/addsysusersubmit")
	public @ResponseBody SubmitResultInfo addsysusersubmit(SysuserQueryVo sysuserQueryVo) throws Exception{


   //默认为成功
		/*ResultInfo resultInfo = new ResultInfo();
		resultInfo.setType(ResultInfo.TYPE_RESULT_SUCCESS);
		resultInfo.setMessage("操作 成功！");*/

		//userService.insertSysuser(sysuserQueryVo.getSysuserCustom());
		//本异常处理麻烦 需经多次调用 如何封装一下？====================
		/*try {
					//调用service执行用户添加
					userService.insertSysuser(sysuserQueryVo.getSysuserCustom());
				} catch (Exception e) {
					//输出异常信息
					e.printStackTrace();
					//对应异常信息进行解析
		//			message = e.getMessage();
		//			type=1;//失败
					//解析系统自定义异常
					if(e instanceof ExceptionResultInfo){
						//抛出的是系统自定义异常
						resultInfo = ((ExceptionResultInfo)e).getResultInfo();
					}else{
						//重新构造“未知错误”异常
						resultInfo = new ResultInfo();
						resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
						resultInfo.setMessage("未知错误！");
					}
				}*/
     //本异常处理麻烦 需经多次调用 如何封装一下？====================

		//TODO:使用全局异常处理器后，在actoin不用进行try/catch捕获 yycg/base/process/exception/ExceptionResolverCustom.java:32
		userService.insertSysuser(sysuserQueryVo.getSysuserCustom());

		//将执行结果返回页面


		//SubmitResultInfo submitResultInfo = new SubmitResultInfo(resultInfo);

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	//return null;
	}

}
