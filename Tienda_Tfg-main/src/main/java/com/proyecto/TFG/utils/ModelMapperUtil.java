package com.proyecto.TFG.utils;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperUtil {

	private ModelMapperUtil() {

	}

	public static <S, T> List<T> transformDtoList(List<S> source, Class<T> targetClass) {
		ModelMapper modelMapper = createModelMapper();
		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());

	}

	public static <T> T transformDto(Object source, Class<T> targetClass) {
		ModelMapper modelMapper = createModelMapper();
		return modelMapper.map(source, targetClass);

	}

	private static ModelMapper createModelMapper() {

		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;

	}

}
