package z.y.config;

import com.power.common.enums.HttpCodeEnum;
import com.power.common.model.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * HTTP响应处理程序 实现ResponseBodyAdvice接口
 */
@RestControllerAdvice
public class RestResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 响应体为CommonResult 则不再封装
        if (body instanceof CommonResult) {
            return body;
        }

        if (body instanceof ResourceRegion) {
            return body;
        }
        // 若为其他类型则需要封装
        return CommonResult.ok(HttpCodeEnum.SUCCESS).setResult(body);
    }
}
