package com.lichong.greenbook.controller;

import com.emdata.common.models.DataGrid;
import com.emdata.common.models.PageParams;
import com.emdata.common.models.PageableTools;
import com.emdata.common.models.response.AjaxResponse;
import com.emdata.common.mvc.bind.enums.SearchOperator;
import com.emdata.common.mvc.bind.search.Search;
import com.emdata.common.mvc.controller.AbstractController;
import com.lichong.greenbook.constant.ResponseCode;
import com.lichong.greenbook.entity.Demo;
import com.lichong.greenbook.service.DemoService;
import com.lichong.greenbook.vo.DemoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lichongsky
 * @date ：Created in 2019/7/25 13:29
 */

@RestController
@RequestMapping(value = "/demo")
@Api(value = "DemoController|示例接口", tags = "demo示例接口",
        description = "示例接口demo")
public class DemoController extends AbstractController<Demo, DemoVo> {
    @Autowired
    private DemoService demoService;

    @PostMapping(value = "")
    public AjaxResponse addUser(@RequestBody Demo demo) {
        demoService.saveUser(demo);
        return new AjaxResponse(demo);
    }

    @GetMapping(value = "")
    @ApiOperation(value = "查找", notes = "基准模版新增")
    public AjaxResponse findAll() {
        List<Demo> list = demoService.findAll();
        return new AjaxResponse(convter(list));
    }

    @DeleteMapping(value = "/id/{id}")
    public AjaxResponse deleteBook(@PathVariable String id) {
        demoService.delete(id);
        return new AjaxResponse(ResponseCode.API_SUCCESS);
    }

    @ApiOperation(value = "查找", notes = "查找单个用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "id", required = true)})
    @GetMapping(value = "/id/{id}")
    public AjaxResponse getUser(@PathVariable String id) {
        Demo user = demoService.findOne(id);
        return new AjaxResponse(user);
    }

    @GetMapping(value = "/name/{name}")
    public AjaxResponse getBookByName(@PathVariable String name) {
        List<Demo> users = demoService.findByName(name);
        return new AjaxResponse(convter(users));
    }


    /**
     * 获取分页
     *
     * @param search
     * @return
     * @throws Exception
     */
    @GetMapping("/getpagebysearch")
    public AjaxResponse getPageBySearch(PageParams page, Sort sort, Demo demo) throws Exception {
        // 处理组装分页参数
        Pageable pageable = PageableTools.basicPage(page.getPageIndex(), page.getPageSize(), page.getOrderType(),
                page.getOrderField());

        // search组装
        Search search = new Search();
        search.setPage(pageable);
        search.addSearchaFilter("name", SearchOperator.eq, demo.getName());

        DataGrid grid = convter(demoService.findPage(search));
        return new AjaxResponse(grid);
    }

    @GetMapping("/getpagebyjpa")
    public AjaxResponse getPageByJpa(PageParams page, Demo demo) {
        return new AjaxResponse(demoService.findPage(page, demo));
    }

    @GetMapping("/getpagebymybatis")
    public AjaxResponse getMybatisPage(PageParams page, Demo demo) {
        DataGrid grid = demoService.findPageByMyBatis(page, demo);
        return new AjaxResponse(grid);
    }
}
