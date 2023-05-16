package z.y.config;

import com.power.common.model.CommonResult;

import com.power.common.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

/**
 * 自定义异常处理
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    // 日志记录
    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * 全局异常处理
     * @param ex 抛出的异常
     * @return 输出结果
     */
    @ExceptionHandler
    public CommonResult<Object> handleGlobalException (Exception ex) {
        // 打印错误日志
        logger.error("Exception e = ", ex);

        // 组装返回对象
        CommonResult<Object> result = new CommonResult<>("500", "server error!");
        result.setSuccess(Boolean.FALSE);
        result.setTimestamp(DateTimeUtil.nowStrTime());
        return result.addData(ex.getMessage()).addTraceId(UUID.randomUUID().toString());
    }

}
