package com.nhnacademy.resident.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHouseholdMovementAddress_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QHouseholdMovementAddress_Pk extends BeanPath<HouseholdMovementAddress.Pk> {

    private static final long serialVersionUID = 1009847533L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHouseholdMovementAddress_Pk pk = new QHouseholdMovementAddress_Pk("pk");

    public final QHousehold household;

    public final DatePath<java.time.LocalDate> localDate = createDate("localDate", java.time.LocalDate.class);

    public QHouseholdMovementAddress_Pk(String variable) {
        this(HouseholdMovementAddress.Pk.class, forVariable(variable), INITS);
    }

    public QHouseholdMovementAddress_Pk(Path<? extends HouseholdMovementAddress.Pk> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHouseholdMovementAddress_Pk(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHouseholdMovementAddress_Pk(PathMetadata metadata, PathInits inits) {
        this(HouseholdMovementAddress.Pk.class, metadata, inits);
    }

    public QHouseholdMovementAddress_Pk(Class<? extends HouseholdMovementAddress.Pk> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.household = inits.isInitialized("household") ? new QHousehold(forProperty("household"), inits.get("household")) : null;
    }

}

