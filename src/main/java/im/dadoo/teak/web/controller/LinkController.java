/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.web.controller;

import im.dadoo.teak.domain.Link;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author codekitten
 */
@Controller
public class LinkController extends BaseController {
  
  @RequestMapping(value = "/link", method = RequestMethod.POST)
  public String save(@RequestParam String name, @RequestParam String url, 
          @RequestParam(required = false) String description) {
    Link link = this.linkService.save(name, url, description);
    if (link != null) {
      return "redirect:/admin/link";
    } else {
      return "redirect:/404";
    }
  }
}
