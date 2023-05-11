package z.y.controller;

import com.power.common.constants.Charset;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class DownloadController {

    @RequestMapping(value = "/download", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void download(HttpServletResponse response) {

        // 文件
        File file = new File("C:/Users/Administrator/Desktop/专业工程消防验收申请内容调整.docx");

        String name = file.getName();
        response.reset();
        response.setContentType("application/octet-stream");

        String replace = UriUtils.encode(name, StandardCharsets.UTF_8);
        response.setHeader("Content-disposition", "attachment; filename=" + replace);
        response.setCharacterEncoding(Charset.DEFAULT_CHARSET);

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) > 0) {
                response.getOutputStream().write(bytes, 0 , len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/download1", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<ResourceRegion> download() throws IOException {

        // 文件
        File file = new File("C:/Users/Administrator/Desktop/专业工程消防验收申请内容调整.docx");
        // 文件路径
        Path path = Paths.get(file.getAbsolutePath());

        ByteArrayResource byteArrayResource = new ByteArrayResource(Files.readAllBytes(path));

        ResourceRegion resourceRegion = new ResourceRegion(byteArrayResource, 1, byteArrayResource.contentLength());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
        headers.setContentLength(file.length());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok().headers(headers).body(resourceRegion);
    }
}
