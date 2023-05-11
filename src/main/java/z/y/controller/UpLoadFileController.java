package z.y.controller;

import com.power.common.util.DateTimeUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UpLoadFileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam CommonsMultipartFile uploadFile, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile");

        System.out.println(realPath);

        String format = DateTimeUtil.long2Str(System.currentTimeMillis(), "yyyy/MM/dd");
        File folder = new File(realPath + "/" + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        // 对上传的文件重命名，避免文件重名
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));

        try {
            // 文件保存
            uploadFile.transferTo(new File(folder, newName));

            // 返回上传文件的访问路径
            return request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
