package org.zoo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zoo.demo.dao.mapper.CityMapper;
import org.zoo.demo.entity.City;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    public City getCity(Integer cityId) {

        return cityMapper.findById(cityId);
    }
}
