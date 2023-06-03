package com.cpad.catalog.utils;

import com.cpad.catalog.exceptions.parent.BadRequestException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.util.StringUtils;

@UtilityClass
public class Commons {

  private static final ModelMapper modelMapper;

  static {
    modelMapper = new ModelMapper();
    modelMapper
        .getConfiguration()
        .setPropertyCondition(Conditions.isNotNull())
        .setMatchingStrategy(MatchingStrategies.STRICT);
  }

  public static <D, T> D mapModel(final T subject, Class<D> tClass) {
    return modelMapper.map(subject, tClass);
  }

  public static <D, T> List<D> mapModels(final Collection<T> entityList, Class<D> outCLass) {
    return entityList.stream()
        .map(entity -> mapModel(entity, outCLass))
        .collect(Collectors.toList());
  }

  public static <S, D> D mapModel(final S source, D destination) {
    modelMapper.map(source, destination);
    return destination;
  }

  public static void validateNumericId(String id) throws BadRequestException {
    if (!StringUtils.hasText(id))
      throw new BadRequestException(Constants.ID_CAN_NOT_BE_EMPTY.getName());

    try {
      Integer.parseInt(id);
    } catch (NumberFormatException ex) {
      throw new BadRequestException(Constants.INVALID_ID.getName());
    }
  }
}
