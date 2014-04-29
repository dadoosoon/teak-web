/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.web.controller;

import im.dadoo.teak.core.service.ArchiveService;
import im.dadoo.teak.core.service.CategoryService;
import im.dadoo.teak.core.service.LinkService;
import im.dadoo.teak.core.service.PageService;
import im.dadoo.teak.domain.Archive;
import im.dadoo.teak.domain.Category;
import im.dadoo.teak.domain.Link;
import im.dadoo.teak.domain.Page;
import im.dadoo.teak.domain.User;
import im.dadoo.teak.web.cons.Cons;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;

/**
 *
 * @author codekitten
 */
public class BaseController {
  
  @Resource
  protected ArchiveService archiveService;
  
  @Resource
  protected LinkService linkService;
  
  @Resource
  protected CategoryService categoryService;
  
  @Resource
  protected PageService pageService;
  
  protected void renderDefault(ModelMap map) {
		this.renderLinks(map);
		this.renderLatestArchives(map);
	}
	
	protected void renderLinks(ModelMap map) {
		List<Link> links = this.linkService.list();
		map.addAttribute("links", links);
	}
	
  protected void renderNav(ModelMap map) {
    List<Category> categories = this.categoryService.list();
    List<Page> pages = this.pageService.list();
    map.addAttribute("categoryNav", categories);
    map.addAttribute("pageNav", pages);
  }
  
	protected void renderLatestArchives(ModelMap map) {
		List<Archive> latestArchives = this.archiveService.list(10);
		map.addAttribute("latestArchives", latestArchives);
	}
	
	protected User getVisitor(HttpSession session) {
		return (User)session.getAttribute(Cons.VISITOR);
	}
	
	protected void setVisitor(HttpSession session, User visitor) {
		session.setAttribute(Cons.VISITOR, visitor);
	}
	
	protected void removeVisitor(HttpSession session) {
		session.removeAttribute(Cons.VISITOR);
	}
}
