package com.smx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smx.dto.Result;
import com.smx.mapper.BlogModelMapper;
import com.smx.model.BlogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    BlogModelMapper blogModelMapper;

    @GetMapping(value = "/index")
    public String index() {
        return "blog_index";
    }

    @GetMapping(value = "/getBlogs")
    public Result getBlogs(@RequestParam(value = "createBy", required = false) final String createBy,
                           @RequestParam(value = "page", required = false, defaultValue = "1") final int pageNo,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "20") final int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<BlogModel> list = blogModelMapper.getBlogs(createBy);
        return new Result(200, "成功", list);
    }

    @GetMapping(value = "/getBlogs")
    public String goBlogs(final Model model,
                          @RequestParam(value = "page", required = false, defaultValue = "1") final int pageNo) {
        PageHelper.startPage(1, 1);
        List<BlogModel> list = blogModelMapper.getBlogs("admin@admin.com");

        /*List<BlogData> results = blogFacade.selectPageable(null, (pageNo-1) * pageSize, pageSize);
        int totalCounts = blogFacade.selectPageableCount(null);
        final SearchPageData<BlogData> data = new SearchPageData<BlogData>();
        data.setPageNo(pageNo);
        data.setPageSize(pageSize);
        data.setResults(results);
        data.setTotalRecords(totalCounts);

        model.addAttribute("blogPageData", data);
        return "blogs";*/
        Page page = (Page)list;
        System.out.println(page.getPages() + " " + page.getTotal() + " ");

        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo.getPages() + " " + pageInfo.getTotal() + " ");

        return "success";
    }

}
