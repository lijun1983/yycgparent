package yycg.business.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.vo.ActiveUser;
import yycg.base.pojo.vo.PageQuery;
import yycg.base.process.context.Config;
import yycg.base.process.result.*;
import yycg.base.service.SystemConfigService;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;
import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.service.YpmlService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Version : 1.0
 * @ClassName :本类名称 YpmlAction
 * @Auther : 创建人 Lijun
 * @Date : 创建时间 2018/8/26 0026 17:14
 * @Description: 描述 null
 * @TODO : 标注注释 供货商药品目录
 * Created by IntelliJ IDEA
 */
@Controller
@RequestMapping("/ypml")
public class YpmlAction
{
  @Autowired
  private SystemConfigService systemConfigService;
  @Autowired
  private YpmlService ypmlService;
  public YpmlAction() {
  }
  /**
   * TODO:供货商药品目录 jsp 页面
   *@当前包名 yycg.business.action 
   *@本类名称 YpmlAction 
   *@参数
   * 
   *@返回值   
   */
  @RequestMapping({"/querygysypml"})
  //@RequestMapping("/querygysypml")
  public String querygysypml(Model model) throws Exception {
    List<Dictinfo> yplblist = this.systemConfigService.findDictinfoByType("001");//药品类别
    model.addAttribute("yplblist", yplblist);
    return "/business/ypml/querygysypml";
  }



  /**
   *@创建人  lijun
   *@创建时间  2018/8/27 0027 上午 12:11
   *@描述
   *@修改人和其它信息
   *@当前包名 yycg.business.action
   *@本类名称 YpmlAction
   *@param  session, gysypmlQueryVo, page, rows]
   *@对像函数方法体的封装 function
   * TODO:   供应药品列表
   *@返回值  yycg.base.process.result.DataGridResultInfo
   * gysypml, usergys, gysypml_control, ypxx 表数据
   */
  @RequestMapping({"/querygysypml_result"})
  @ResponseBody
  public DataGridResultInfo querygysypml_result(HttpSession session, GysypmlQueryVo gysypmlQueryVo, int page, int rows) throws Exception{
    

    //设置当前用户
    ActiveUser activeUser = (ActiveUser)session.getAttribute("activeUser");
    //用户所属单位
    String usergysid = activeUser.getSysid();

    //列表总记录
    int total = this.ypmlService.findGysypmlCount(usergysid,gysypmlQueryVo);

    PageQuery pageQuery = new PageQuery();

    pageQuery.setPageParams(total,rows,page);

    gysypmlQueryVo.setPageQuery(pageQuery);

    //列表
    List<GysypmlCustom> list = this.ypmlService.findGysypmlList(usergysid,gysypmlQueryVo);
    DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();

    dataGridResultInfo.setTotal(total);

    dataGridResultInfo.setRows(list);



    return dataGridResultInfo;
  }

  /**
   *@创建人  lijun
   *@创建时间  2018/8/27 0027 上午 12:14
   *@描述
   *@修改人和其它信息
   *@当前包名 yycg.business.action
   *@本类名称 YpmlAction
   *@param  model
   *@对像函数方法体的封装 function
   * TODO:   供货药品添加  含 查询 jsp 页面
   *@返回值  java.lang.String
   */
  @RequestMapping("/queryaddgysypml")
  public String queryaddgysypml(Model model) throws Exception {
    // 药品类别
    List<Dictinfo> yplblist = systemConfigService.findDictinfoByType("001");
    model.addAttribute("yplblist", yplblist);
    return "/business/ypml/queryaddgysypml";
  }

  /**
   *@创建人  lijun
   *@创建时间  2018/8/27 0027 上午 12:20
   *@描述
   *@修改人和其它信息
   *@当前包名 yycg.business.action
   *@本类名称 YpmlAction
   *@param  session, gysypmlQueryVo, page, rows]
   *@对像函数方法体的封装 function
   * TODO:    供货药品添加 含  查询列表结果集,json
   *@返回值  yycg.base.process.result.DataGridResultInfo
   *ypxx 数据表
   * querygysypml_result   与这个方法内容一样  queryaddgysypml_result  ；就是方法名不一样
   */
  @RequestMapping("/queryaddgysypml_result")
  public @ResponseBody
  DataGridResultInfo queryaddgysypml_result(HttpSession session,GysypmlQueryVo gysypmlQueryVo,int page, int rows) throws Exception {
    // 当前用户
    ActiveUser activeUser = (ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);

    // 用户所属的单位
    String usergysid = activeUser.getSysid();// 单位id

    // 列表的总数
    int total = ypmlService.findAddGysypmlCount(usergysid, gysypmlQueryVo);

    // 分页参数
    PageQuery pageQuery = new PageQuery();
    pageQuery.setPageParams(total, rows, page);
    gysypmlQueryVo.setPageQuery(pageQuery);// 设置分页参数

    // 分页查询列表
    List<GysypmlCustom> list = ypmlService.findAddGysypmlList(usergysid,gysypmlQueryVo);


    DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
    dataGridResultInfo.setTotal(total);
    dataGridResultInfo.setRows(list);

    return dataGridResultInfo;
  }


  /**
   *@创建人  lijun
   *@创建时间  2018/8/27 0027 上午 2:00
   *@描述
   *@修改人和其它信息
   *@当前包名 yycg.business.action
   *@本类名称 YpmlAction
   *@param  session,
   *@param   indexs   接收页面选中的行序号(多个)
   *@param gysypmlQueryVo   页面提交的业务数据，保存在list中
   *@对像函数方法体的封装 function
   * List<YpxxCustom> list = gysypmlQueryVo.getYpxxCustoms();  yycg/business/pojo/vo/GysypmlQueryVo.java:19
   * TODO: //供货商药品目录 批量  添加提交
   *@返回值  yycg.base.process.result.SubmitResultInfo
   * TODO: WEB-INF/jsp/business/ypml/queryaddgysypml.jsp:179
   * TODO: 按 ctrl + shift + alt + n  查找  var  gysypmladd   在 jsp 页面
   * TODO: var columns  列表数据 在 jsp 页面
   * TODO: jquerySubByFId('gysypmladdqueryForm',gysypmladd_callback, null);  提交表单 在 jsp 页面
   * TODO: spring/springmvc.xml:19  需要加入 <mvc:annotation-driven/>
   */
    @RequestMapping("/addgysypmlsubmit")
  public @ResponseBody
    SubmitResultInfo addgysypmlsubmit(HttpSession session, int[] indexs, GysypmlQueryVo gysypmlQueryVo )throws Exception{

    ActiveUser activeUser = (ActiveUser)session.getAttribute(Config.ACTIVEUSER_KEY);
    //TODO:获取当前用户所属单位 即供货商的id
    String usergysid = activeUser.getSysid();

    //页面提交的业务数据（多个），要处理的业务数据，页面中传入的参数
    List<YpxxCustom> list = gysypmlQueryVo.getYpxxCustoms();

    //处理数据的总数
    int count = indexs.length;
    //处理成功的数量
    int count_success = 0;
    //处理失败的数量
    int count_error = 0;

    //处理失败的原因
    List<ResultInfo> msgs_error = new ArrayList<ResultInfo>();

    for(int i=0;i<count;i++){

      ResultInfo resultInfo = null;

      //根据选中行的序号获取要处理的业务数据(单个)
      YpxxCustom ypxxCustom =  list.get(indexs[i]);//表示通过 ypxxCustom 扩展类 查找与表单 indexs[i] 提交过来相同的 id
      String ypxxid = ypxxCustom.getId();//TODO:页面中传入的参数  将 getId()赋值给  String ypxxid

      try {
        //插入记录
         ypmlService.insertGysypml(usergysid, ypxxid);
      } catch (Exception e) {
        e.printStackTrace();

        //进行异常解析
        if(e instanceof ExceptionResultInfo){
          resultInfo = ((ExceptionResultInfo)e).getResultInfo();
        }else{
          //构造未知错误异常
          resultInfo = ResultUtil.createFail(Config.MESSAGE, 900, null);
        }
      }
      if(resultInfo == null){
        //说明成功
        count_success++;
      }else{
        count_error++;
        //记录失败原因
        msgs_error.add(resultInfo);
      }
    }
    //提示用户成功数量、失败数量、失败原因
    //改成返回详细信息
    return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 907, new Object[]{count_success,count_error}), msgs_error);
    }







}
