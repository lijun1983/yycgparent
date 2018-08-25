package yycg.util;

import java.util.List;

/**
 * TODO:药品目录  测试导 执行数据入数据
 * @author Thinkpad
 *
 */
public class HxlsOptRowsInterfaceImpl implements HxlsOptRowsInterface {

	@Override
	public String optRows(int sheetIndex, int curRow, List<String> rowlist)
			throws Exception {
		//插入数据库

			/*System.out.println("============================");
			System.out.println(rowlist.get(0));
			System.out.println(rowlist.get(1));
			System.out.println(rowlist.get(2));*/
			//yycg.util.HxlsRead.optRows()
			System.out.println("sheetIndex="+sheetIndex+"curRow="+curRow+rowlist);
		return null;
	}
	
}
