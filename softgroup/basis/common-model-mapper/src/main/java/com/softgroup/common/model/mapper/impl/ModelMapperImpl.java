package com.softgroup.common.model.mapper.impl;

import com.softgroup.common.model.mapper.api.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author AlexKazmirchuk
 * @since 31.03.17.
 */

@Component
public class ModelMapperImpl implements ModelMapper {

    private org.modelmapper.ModelMapper modelMapper;

    public ModelMapperImpl() {
        modelMapper = new org.modelmapper.ModelMapper();
        // todo configure later
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}
