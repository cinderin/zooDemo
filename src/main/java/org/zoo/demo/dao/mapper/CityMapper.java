package org.zoo.demo.dao.mapper;

import org.springframework.stereotype.Repository;
import org.zoo.demo.entity.City;

@Repository
public interface CityMapper {

    public City findById(Integer cityId);
}