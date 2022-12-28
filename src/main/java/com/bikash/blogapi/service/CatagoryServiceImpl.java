package com.bikash.blogapi.service;

import com.bikash.blogapi.binding.CatagoryDto;
import com.bikash.blogapi.entity.CatagoryEntity;
import com.bikash.blogapi.exception.ResourceNotFoundException;
import com.bikash.blogapi.repo.CatagoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatagoryRepo catagoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param catagoryDto
     * @return
     */
    @Override
    public CatagoryDto createCatagory(CatagoryDto catagoryDto) {
        CatagoryEntity entity = modelMapper.map(catagoryDto, CatagoryEntity.class);
        CatagoryEntity createdCatagory = catagoryRepo.save(entity);
        return modelMapper.map(createdCatagory, CatagoryDto.class);
    }

    /**
     * @param catagoryDto
     * @param catagoryid
     * @return
     */
    @Override
    public CatagoryDto updateCatagory(CatagoryDto catagoryDto, Long catagoryid) {
        CatagoryEntity catagoryEntity1 = catagoryRepo.findById(catagoryid).orElseThrow(() -> new ResourceNotFoundException("catagory", "id", catagoryid));

        //CatagoryEntity catagoryEntity =new CatagoryEntity();
        // catagoryEntity.setCatagoryId();
        catagoryEntity1.setCatagoryName(catagoryDto.getCatagoryName());
        catagoryEntity1.setCatagoryDescription(catagoryDto.getCatagoryDescription());
        catagoryRepo.save(catagoryEntity1);

        return modelMapper.map(catagoryEntity1, CatagoryDto.class);
    }

    /**
     * @param catagoryId
     * @return
     */
    @Override
    public void deleteCatagory(Long catagoryId) {
        catagoryRepo.deleteById(catagoryId);
    }

    /**
     * @param catagoryId
     * @return
     */
    @Override
    public CatagoryDto getCatagoryById(Long catagoryId) {
        CatagoryEntity catagoryEntity = catagoryRepo.findById(catagoryId).orElseThrow(() -> new ResourceNotFoundException("catagory", "id", catagoryId));
        return modelMapper.map(catagoryEntity,CatagoryDto.class);
    }

    /**
     * @return
     */
    @Override
    public List<CatagoryDto> getAllCatagoryById() {
        List<CatagoryEntity> catagories = catagoryRepo.findAll();
        List<CatagoryDto> catagoryDtos = catagories.stream().map(cat -> modelMapper.map(cat, CatagoryDto.class)).collect(Collectors.toList());
        return catagoryDtos;
    }

//    private CatagoryEntity catagoryEntityToDto(CatagoryDto catagoryDto){
//        CatagoryEntity catagoryEntity=new CatagoryEntity();
//        modelMapper.map(catagoryDto , catagoryEntity);
//        return catagoryEntity;
//    }
//
//    private CatagoryDto catagoryDtoToEntity(CatagoryEntity catagoryEntity){
//        CatagoryDto catagoryDto=new CatagoryDto();
//        modelMapper.map(catagoryEntity , catagoryDto);
//        return catagoryDto;
//    }
}
