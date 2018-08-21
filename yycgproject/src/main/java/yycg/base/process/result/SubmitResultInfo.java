package yycg.base.process.result;


/**
 * 系统提交结果结果  类型
 * @author Thinkpad
 *  ResultInfo  系统提示信息封装类
 *
 */
public class SubmitResultInfo
{

	public SubmitResultInfo(ResultInfo resultInfo){
		this.resultInfo = resultInfo;
	}
	
	//操作结果信息
	private ResultInfo resultInfo;
	
	public ResultInfo getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(ResultInfo resultInfo) {
		this.resultInfo = resultInfo;
	}
		
}
