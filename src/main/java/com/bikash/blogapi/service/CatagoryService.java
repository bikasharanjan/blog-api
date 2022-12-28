package com.bikash.blogapi.service;

import com.bikash.blogapi.binding.CatagoryDto;

import java.util.List;

public interface CatagoryService {

    //create
   public  CatagoryDto createCatagory(CatagoryDto catagoryDto);

    // update

    public  CatagoryDto updateCatagory(CatagoryDto catagoryDto , Long catagoryid);
    //deleteById

    public  void deleteCatagory(Long catagoryId);

    //getById

    public  CatagoryDto getCatagoryById(Long catagoryId);

    //getAll

    public List<CatagoryDto> getAllCatagoryById();
}
