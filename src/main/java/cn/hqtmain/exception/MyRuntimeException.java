package cn.hqtmain.exception;
/**
* @ClassName: MyRuntimeException
* @Description:(自定义处理异常)
* @author: ZhouLingZhang
* @date 2019年9月3日
 */
public class MyRuntimeException extends Exception
{	
	private static final long serialVersionUID = -1352123243429356486L;
	public MyRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);		
	}
	public MyRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	public MyRuntimeException(String message) {
		super(message);		
	}
	public MyRuntimeException(Throwable cause) {
		super(cause);		
	}

}
