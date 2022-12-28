package com.bikash.blogapi.controller;

import com.bikash.blogapi.apiresponse.ApiResponse;
import com.bikash.blogapi.binding.CatagoryDto;
import com.bikash.blogapi.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cat/")
public class CatagoryController {

    @Autowired
    private CatagoryService catagoryService;

    @PostMapping("/create")
    public ResponseEntity<CatagoryDto> saveCatagory(@RequestBody CatagoryDto catagoryDto){
        CatagoryDto catagory = catagoryService.createCatagory(catagoryDto);
        return new ResponseEntity<>(catagory , HttpStatus.CREATED);
    }
    @PutMapping("/update/{catId}")
    public ResponseEntity<CatagoryDto> updateCatagory(@RequestBody CatagoryDto catagoryDto , @PathVariable("catId") Long catId){
        CatagoryDto catagoryDto1 = catagoryService.updateCatagory(catagoryDto, catId);
        return new ResponseEntity<>(catagoryDto1 , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{catId}")
    public ResponseEntity<ApiResponse> deleteCatagory( @PathVariable("catId") Long catId){
      catagoryService.deleteCatagory(catId);
      return new ResponseEntity<>(new ApiResponse("user deleted" ,true)  , HttpStatus.OK);
    }

    @GetMapping("/getbyid/{catId}")
    public ResponseEntity<CatagoryDto> getCatagoryById( @PathVariable("catId") Long catId){
        CatagoryDto catagoryById = catagoryService.getCatagoryById(catId);
        return new ResponseEntity<>(catagoryById  , HttpStatus.OK);
    }

    @GetMapping("/getallCat")
    public ResponseEntity<List<CatagoryDto>> getallCatagory(){
        List<CatagoryDto> allCatagoryById = catagoryService.getAllCatagoryById();
        return new ResponseEntity<>(allCatagoryById  , HttpStatus.OK);
    }


}
