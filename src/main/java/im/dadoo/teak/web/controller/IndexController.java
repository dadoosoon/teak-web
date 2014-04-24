/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.web.controller;

import im.dadoo.teak.core.service.PageService;
import im.dadoo.teak.domain.Archive;
import im.dadoo.teak.domain.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author codekitten
 */
@Controller
public class IndexController extends BaseController {
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(ModelMap map) {
    this.renderDefault(map);
    List<Archive> noticeArchives = this.archiveService.listByCategoryId(1, 0, 10);
    List<Archive> activityArchives = this.archiveService.listByCategoryId(2, 0, 10);
    List<Archive> researchArchives = this.archiveService.listByCategoryId(3, 0, 10);
    List<Archive> imageArchives = this.archiveService.listByCategoryId(16, 0, 10);
    Page introductionPage = this.pageService.findById(1);
    
    map.addAttribute("noticeArchives", noticeArchives);
		map.addAttribute("activityArchives", activityArchives);
		map.addAttribute("researchArchives", researchArchives);
		map.addAttribute("imageArchives", imageArchives);
		map.addAttribute("introductionPage", introductionPage);
    
    return "index";
  }
}
