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

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler
    public CommonResult<Object> handleGlobalException (Exception ex) {
        logger.error("Exception e = ", ex);

        CommonResult<Object> result = new CommonResult<>("500", "server error!");
        result.setSuccess(Boolean.FALSE);
        result.setTimestamp(DateTimeUtil.nowStrTime());
        return result.addData(ex.getMessage()).addTraceId(UUID.randomUUID().toString());
    }

}
