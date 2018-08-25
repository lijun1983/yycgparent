package yycg.business.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import yycg.base.pojo.po.Dictinfo;
import yycg.base.process.context.Config;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.SystemConfigService;
import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YpxxQueryVo;
import yycg.business.service.YpxxService;
import yycg.util.ExcelExportSXXSSF;
import yycg.util.HxlsOptRowsInterface;
import yycg.util.HxlsRead;
import yycg.util.UUIDBuild;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>
 * Title: YpxxAction
 * </p>
 * <p>
 * Description:药品目录
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 苗润土
 * @date 2014年11月29日下午3:25:41
 * @version 1.0
 */
/**
 *@创建人  lijun
 *@创建时间  2018/8/25 0025 下午 10:43
 *@描述  TODO: 药品目录     导出    导入
 *@修改人和其它信息
 *@当前包名 yycg.business.action
 *@本类名称 YpxxAction
 *@参数  
 *@对像函数方法体的封装 function
 *@返回值  
 */
@Controller
@RequestMapping("/ypml")
public class YpxxAction {

	@Autowired
	private YpxxService ypxxService;
	
	@Autowired
	private SystemConfigService systemConfigService;
	@Autowired
	private HxlsOptRowsInterface ypxxImportService;
	/**
	 *@创建人  lijun
	 *@创建时间  2018/8/25 0025 下午 10:15
	 *@描述  TODO:导出页面展示
	 *@修改人和其它信息
	 *@当前包名 yycg.business.action
	 *@本类名称 YpxxAction
	 *@参数  [model]
	 *@对像函数方法体的封装 function
	 * TODO:   systemConfigService.findDictinfoByType("001"); 药品类别
	 * TODO:   systemConfigService.findDictinfoByType("003"); 交易状态
	 *@返回值  java.lang.String
	 */
	@RequestMapping("/exportYpxx")
	public String exportYpxx(Model model) throws Exception {

		//TODO 药品类别   数字字典表
		List<Dictinfo> yplblist = systemConfigService.findDictinfoByType("001"); 
		
		//TODO:交易状态   数字字典表
		List<Dictinfo> jyztlist = systemConfigService.findDictinfoByType("003");
		
		model.addAttribute("yplblist", yplblist);
		model.addAttribute("jyztlist", jyztlist);
		
		return "/business/ypml/exportYpxx";
	}
	/**
	 *@创建人  lijun
	 *@创建时间  2018/8/25 0025 下午 10:16
	 *@描述  TODO:  导出提交
	 *@修改人和其它信息
	 *@当前包名 yycg.business.action
	 *@本类名称 YpxxAction
	 *@参数  [ypxxQueryVo] 自定义包装类
	 *@对像函数方法体的封装 function
	 * TODO:  spring/applicationContext-business-service.xml:17     id="ypxxService"
	 * TODO:  String filePath = "L:/upload/linshi/";
	 *TODO:  封装类  ExcelExportSXXSSF.start(filePath,"/upload/", filePrefix, fieldNames, fieldCodes, flushRows);
	 *               (filePath[服务器路径],"/upload/【导出文件web下载路径】", filePrefix【导出文件名的前缀 】, fieldNames【导出文件列标题】, fieldCodes【导出数据对象的字段名称】, flushRows【写磁盘控制参数】);
	 *TODO:   ypxxService.findYpxxList(ypxxQueryVo);  导出满足条件的数据对象
	 *TODO:   执行导出   excelExportSXXSSF.writeDatasByObject(list);
	 *TODO:   输出文件，返回下载文件的http地址，已经包括虚拟目录  String webpath = excelExportSXXSSF.exportFile();
	 *@返回值  yycg.base.process.result.SubmitResultInfo
	 */
	@RequestMapping("/exportYpxxSubmit")
	public @ResponseBody SubmitResultInfo exportYpxxSubmit(YpxxQueryVo ypxxQueryVo) throws Exception {
		// 调用封装类执行导出

		// 导出文件存放的路径，并且是虚拟目录指向的路径(即服务器路径)
		String filePath = "L:/upload/linshi/";
		//改为从系统参数配置表获取参数值
		//String filePath = systemConfigService.findBasicinfoById("00301").getValue();//TODO:(从服务器 取出 路径)
		// 导出文件的前缀
		String filePrefix = "ypxx";
		// -1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
		int flushRows = 100;

		// TODO:定义导出数据的title
		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add("流水号");
		fieldNames.add("通用名");
		fieldNames.add("剂型");
		fieldNames.add("规格");
		fieldNames.add("转换系数");
		fieldNames.add("生产企业");
		fieldNames.add("商品名称");
		fieldNames.add("中标价格");
		fieldNames.add("交易状态");

		// 告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
		List<String> fieldCodes = new ArrayList<String>();
		fieldCodes.add("bm");// 药品流水号
		fieldCodes.add("mc");// 通用名
		fieldCodes.add("jx");
		fieldCodes.add("gg");
		fieldCodes.add("zhxs");
		fieldCodes.add("scqymc");
		fieldCodes.add("spmc");
		fieldCodes.add("zbjg");
		fieldCodes.add("jyztmc");

		// 上边的代码可以优化为，将title和title对应的 pojo的属性，使用map存储
		// ....

		// 注意：fieldCodes和fieldNames个数必须相同且属性和title顺序一一对应，这样title和内容才一一对应

		// 开始导出，执行一些workbook及sheet等对象的初始创建
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath,"/upload/", filePrefix, fieldNames, fieldCodes, flushRows);


		// 导出的数据通过service取出
		List<YpxxCustom> list = ypxxService.findYpxxList(ypxxQueryVo);

		// 执行导出
		excelExportSXXSSF.writeDatasByObject(list);
		// 输出文件，返回下载文件的http地址，已经包括虚拟目录
		String webpath = excelExportSXXSSF.exportFile();

		System.out.println(webpath);

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 313, new Object[] {list.size(),webpath}));// webpath 下载地址




	}
//=========================================================================================================================================================
	/**
	 *@创建人  lijun
	 *@创建时间  2018/8/25 0025 下午 10:37
	 *@描述  TODO: 导入提交 jsp页面
	 *@修改人和其它信息
	 *@当前包名 yycg.business.action
	 *@本类名称 YpxxAction
	 *@参数  [model]
	 *@对像函数方法体的封装 function
	 *@返回值  java.lang.String
	 */
	@RequestMapping({"/importypxx"})
	public String importypxx(Model model) throws Exception {
		return "/business/ypml/importypxx";
	}

	/**
	 *@创建人  lijun
	 *@创建时间  2018/8/25 0025 下午 11:35
	 *@描述
	 *@修改人和其它信息
	 *@当前包名 yycg.business.action
	 *@本类名称 YpxxAction
	 *@param  ypxximportfile 与 jsp <input type="file" name="ypxximportfile" /> 相同 WEB-INF/jsp/business/ypml/importypxx.jsp:69
	 *@对像函数方法体的封装 function
	 * TODO:   new HxlsRead(absolutePath,1,ypxxImportService); absolutePath 就是导入的文件 ,就是导入电子表文件中工作薄的 哪个 sheet 表  本例 1 表示第二个表,导入接口的实现类对象
	 * TODO:   xls2csv.process();遍历 excel 文件
	 * TODO:   spring/springmvc.xml:37   id="multipartResolver"
	 * TODO:   spring/applicationContext-business-service.xml:19       id="ypxxImportService"
	 *@返回值  yycg.base.process.result.SubmitResultInfo
	 */
	@RequestMapping("/importypxxsubmit")
	public @ResponseBody SubmitResultInfo importypxxsubmit(MultipartFile ypxximportfile)throws Exception{

		//将上传的文件写到磁盘
		String originalFilename  = ypxximportfile.getOriginalFilename();
		//写入磁盘的文件
		File file = new File("L:/upload/linshi/"+ UUIDBuild.getUUID()+originalFilename.substring(originalFilename.lastIndexOf(".")));
		if(!file.exists()){
			//如果文件目录 不存在则创建
			file.mkdirs();
		}

		//将内存中的文件写磁盘
		ypxximportfile.transferTo(file);
		//上传文件磁盘上路径
		String absolutePath = file.getAbsolutePath();


		//调用工具类进行药品目录 导入
		HxlsRead xls2csv = null;
		try {
			//第一个参数就是导入的文件
			//第二个参数就是导入电子表文件中工作薄的 哪个 sheet 表  本例 1 表示第二个表
			//第三个参数导入接口的实现类对象
			xls2csv = new HxlsRead(absolutePath,1,ypxxImportService);
			xls2csv.process();//TODO:遍历 excel 文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//提示导入成功条数
		long success_num = xls2csv.getOptRows_success();
		//导入失败数量
		long failure_num = xls2csv.getOptRows_failure();

		//对导入失败记录处理
		//获取导入失败记录
		//xls2csv.getFailrows()
		//获取导入记录的title
		//xls2csv.getRowtitle();
		//获取导入失败原因
		//xls2csv.getFailmsgs()

		//将上边获取到的失败记录、title、失败原因，导出成一个 excel
		//使用工具类进行导出，得到导出文件下载路径
		//......


		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 314, new Object[]{
				success_num,failure_num
		}));
	}







}
