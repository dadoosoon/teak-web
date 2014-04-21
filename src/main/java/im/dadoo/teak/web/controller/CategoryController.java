/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.web.controller;

import im.dadoo.teak.domain.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author codekitten
 */
@Controller
public class CategoryController extends BaseController {
  
  @RequestMapping(value = "/category", method = RequestMethod.POST)
  public String save(@RequestParam String name, 
          @RequestParam(required = false) String description) {
    Category category = this.categoryService.save(name, description);
    if (category != null) {
      return "redirect:/admin/category";
    } else {
      return "redirect:/404";
    }
  }
}
