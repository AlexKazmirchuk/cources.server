package com.softgroup.common.model.mapper.api;

/**
 * @author AlexKazmirchuk
 * @since 31.03.17.
 */
public interface ModelMapper {
    <D> D map(Object source, Class<D> destinationType);
}
