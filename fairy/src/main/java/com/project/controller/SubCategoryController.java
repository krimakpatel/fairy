package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.SubCategoryVO;
import com.project.service.CategoryService;
import com.project.service.SubCategoryService;

@Controller
public class SubCategoryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@RequestMapping(value="loadSubCategory",method=RequestMethod.GET)
	public ModelAndView loadSubCategory(){
		List categoryList = this.categoryService.search();
		return new ModelAndView("admin/addSubCategory","SubCategoryVO",new SubCategoryVO()).
				addObject("categoryList",categoryList);
	}
	
	@RequestMapping(value="insertSubCategory",method=RequestMethod.POST)
	public ModelAndView insertSubCategory(@ModelAttribute SubCategoryVO subCategoryVO){
		this.subCategoryService.insert(subCategoryVO);
		return new ModelAndView("redirect:/viewSubCategory");
	}
	
	@RequestMapping(value="viewSubCategory",method=RequestMethod.POST)
	public ModelAndView viewSubCategory(@ModelAttribute SubCategoryVO subCategoryVO){
		List subcategoryList = this.subCategoryService.search();
		return new ModelAndView("admin/viewSubCategory","subcategoryList",subcategoryList);
	}
	
}
