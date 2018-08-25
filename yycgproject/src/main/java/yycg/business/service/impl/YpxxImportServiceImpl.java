package yycg.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yycg.business.dao.mapper.YpxxMapper;
import yycg.business.pojo.po.Ypxx;
import yycg.util.HxlsOptRowsInterface;
import yycg.util.UUIDBuild;

import java.util.List;

public class YpxxImportServiceImpl implements HxlsOptRowsInterface {
	
	@Autowired
	private YpxxMapper ypxxMapper;
/**
 *@创建人  lijun
 *@创建时间  2018/8/26 0026 上午 12:20
 *@描述   药品 目录
 *@修改人和其它信息
 *@当前包名 yycg.business.service.impl
 *@本类名称 YpxxImportServiceImpl
 *@param  
 *@对像函数方法体的封装 function
 * TODO:  导入实现类 方法
 *@返回值  
 */
	@Override
	public String optRows(int sheetIndex, int curRow, List<String> rowlist)
			throws Exception {
		try {
			//得到导入的数据
			//rowlist数据 是一行数据，按照模版解析
			String mc = rowlist.get(0);//通用名
			String jx = rowlist.get(1);//剂型
			String gg = rowlist.get(2);//规格 
			String zhxs = rowlist.get(3);//转换系数
			String zbjg = rowlist.get(4);//中标价格
			String scqymc = rowlist.get(5);//生产企业
			String spmc = rowlist.get(6);//商品名
			String jyzt = rowlist.get(7);//交易状态
			
			//进行校验
			//校验中标价格合法性
			//校验交易状态的合法性
			if(jyzt == null || (!jyzt.equals("1") && !jyzt.equals("2"))){
				return "交易状态输入值不对，请输入1：正常,2：暂停";
			}
			
			//添加唯一校验
			//校验通用名、剂型、规格、转换系数、生产企业、商品名
			//思路：根据通用名、剂型、规格、转换系数、生产企业、商品名，查询，如果查询到记录，说明 存在重复记录
			//.....
			
			Ypxx ypxx = new Ypxx();
			ypxx.setId(UUIDBuild.getUUID());
			ypxx.setMc(mc);
			ypxx.setJx(jx);
			ypxx.setGg(gg);
			ypxx.setZhxs(zhxs);
			ypxx.setScqymc(scqymc);
			ypxx.setSpmc(spmc);
			ypxx.setZbjg(Float.parseFloat(zbjg));
			ypxx.setJyzt(jyzt);
			
			
			//校验调用mapper
			ypxxMapper.insert(ypxx);
		} catch (Exception e) {
			e.printStackTrace();
			return "导入失败！";
		}
		
		
		return "success";
	}

}
