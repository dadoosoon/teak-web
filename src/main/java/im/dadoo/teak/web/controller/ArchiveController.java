/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.web.controller;

import im.dadoo.teak.domain.Archive;
import im.dadoo.teak.domain.Category;
import im.dadoo.teak.web.cons.Cons;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author codekitten
 */
@Controller
public class ArchiveController extends BaseController {
  
  @RequestMapping(value = "/archive/{id}", method = RequestMethod.GET)
	public String getItemPage(ModelMap map, @PathVariable Integer id) {
		
		this.renderDefault(map);
		Archive archive = this.archiveService.findById(id);
		if (archive != null) {
			this.archiveService.click(id);
			map.addAttribute("archive", archive);
			return "post-item";
		}
		else {
			map.addAttribute(Cons.ERROR, "无此文章");
			return "forward:/404";
		}
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public String getListPage(ModelMap map, @PathVariable Integer id,
			@RequestParam(required = false) Integer pagecount) {
		if (pagecount == null) pagecount = 0;
		Category category = this.categoryService.findById(id);
		if (category != null) {
			
			this.renderDefault(map);
			
			List<Archive> archives = this.archiveService.listByCategoryId(id, pagecount, Cons.DEFAULT_PAGE_SIZE);
			map.addAttribute("category", category);
			map.addAttribute("archives", archives);
			map.addAttribute("pagecount", pagecount);
//			Integer maxPagecount = 1 + 
//					this.postService.listByCategoryId(id, 0, Integer.MAX_VALUE).size() / Cons.DEFAULT_PAGE_SIZE;
      Integer maxPagecount = 10;
			map.addAttribute("maxPagecount", maxPagecount);
			return "list";
		}
		else {
			map.addAttribute(Cons.ERROR, "无此分类");
			return "forward:/404";
		}
	}
}
