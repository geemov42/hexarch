package io.geemov42.hexarch.domain.commons.mappers;

import org.hibernate.Hibernate;
import org.mapstruct.Condition;
import org.mapstruct.InheritInverseConfiguration;

import java.util.Collection;

/**
 * This interface will be used by mapStruct to generate default base methods.
 * If your entity and your dto have the same fields name, you don't need to override.
 *
 * IMPORTANT : Don't include logic into a mapper. A mapper is there only to map between object, not to calculate something.
 *
 * to have more information, read the mapStruct doc
 *
 * @param <DTO>
 * @param <ENTITY>
 * @author kel
 */
public interface GenericMapper<DTO, ENTITY> {

    @InheritInverseConfiguration
    DTO toDataObject(ENTITY entity);

    Collection<DTO> toDataObjects(Collection<ENTITY> entities);

    ENTITY toEntity(DTO dto);

    Collection<ENTITY> toEntities(Collection<DTO> dtos);

    @Condition
    default boolean isInitialized(Collection<?> value) {
        return value != null && Hibernate.isInitialized(value);
    }

    default boolean isInitialized(Object value) {
        return value != null && Hibernate.isInitialized(value);
    }
}

