package z.y.controller;

import com.power.common.enums.HttpCodeEnum;
import com.power.common.model.CommonResult;
import org.springframework.web.bind.annotation.*;
import z.y.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MyController {


    @Resource
    private UserMapper userMapper;

    @GetMapping("/my")
    public Integer index() {
        return userMapper.CountAll();
    }

    @GetMapping("/my1")
    public CommonResult<Object> test() {

        // throw new RuntimeException("eeeee");
        HashMap<String, Object> map = new HashMap<>();
        map.put("aa",11);
        map.put("ab",12);
        map.put("ac",13);

        return CommonResult.ok(HttpCodeEnum.SUCCESS).addData(map);
    }

    @GetMapping("/my2")
    public List<String> test1() {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("AAA");
        strings.add("AAA");
        strings.add("AAA");

        return strings;
    }

    @GetMapping("/my3")
    public Map<String, Object> test2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("aa",11);
        map.put("ab",12);
        map.put("ac",13);
        return map;
    }

    @GetMapping("/my4")
    public Integer test3() {

        return 1 / 0;
    }
}
