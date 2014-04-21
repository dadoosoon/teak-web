/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.web.controller;

import im.dadoo.teak.domain.Archive;
import im.dadoo.teak.domain.Category;
import im.dadoo.teak.domain.Link;
import im.dadoo.teak.domain.Page;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author codekitten
 */
@Controller
public class AdminController extends BaseController {
  
  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public String getAdminPage() {
    return "admin/admin";
  }
  
  @RequestMapping(value = "/admin/category", method = RequestMethod.GET)
  public String getAdminCategoryPage(ModelMap map) {
    List<Category> categories = this.categoryService.list();
    map.addAttribute("categories", categories);
    return "admin/category";
  }
  
  @RequestMapping(value = "/admin/category/add", method = RequestMethod.GET)
  public String getAdminCategoryAddPage() {
    return "admin/category-add";
  }
  
  @RequestMapping(value = "/admin/link", method = RequestMethod.GET)
  public String getAdminLinkPage(ModelMap map) {
    List<Link> links = this.linkService.list();
    map.addAttribute("links", links);
    return "admin/link";
  }
  
  @RequestMapping(value = "/admin/link/add", method = RequestMethod.GET)
  public String getAdminLinkAddPage() {
    return "admin/link-add";
  }
  
  @RequestMapping(value = "/admin/archive", method = RequestMethod.GET)
  public String getAdminArchivePage(ModelMap map, 
          @RequestParam(required = false) Integer pagecount,
          @RequestParam(required = false) Integer pagesize) {
    List<Archive> archives = this.archiveService.list(pagecount, pagesize);
    Map<Integer, Category> categoryMap = this.categoryService.map();
    map.addAttribute("archives", archives);
    map.addAttribute("categoryMap", categoryMap);
    return "admin/archive";
  }
  
  @RequestMapping(value = "/admin/archive/add", method = RequestMethod.GET)
  public String getAdminArchiveAddPage(ModelMap map) {
    List<Category> categories = this.categoryService.list();
    map.addAttribute("categories", categories);
    return "admin/archive-add";
  }
  
  @RequestMapping(value = "/admin/page", method = RequestMethod.GET)
  public String getAdminPagePage(ModelMap map) {
    List<Page> pages = this.pageService.list();
    map.addAttribute("pages", pages);
    return "admin/page";
  }
  
  @RequestMapping(value = "/admin/page/add", method = RequestMethod.GET)
  public String getAdminPageAddPage() {
    return "admin/page-add";
  }
}
