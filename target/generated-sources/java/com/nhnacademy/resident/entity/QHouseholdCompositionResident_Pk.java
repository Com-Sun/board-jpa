package com.nhnacademy.resident.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHouseholdCompositionResident_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QHouseholdCompositionResident_Pk extends BeanPath<HouseholdCompositionResident.Pk> {

    private static final long serialVersionUID = -445586568L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHouseholdCompositionResident_Pk pk = new QHouseholdCompositionResident_Pk("pk");

    public final QHousehold household;

    public final QResident resident;

    public QHouseholdCompositionResident_Pk(String variable) {
        this(HouseholdCompositionResident.Pk.class, forVariable(variable), INITS);
    }

    public QHouseholdCompositionResident_Pk(Path<? extends HouseholdCompositionResident.Pk> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHouseholdCompositionResident_Pk(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHouseholdCompositionResident_Pk(PathMetadata metadata, PathInits inits) {
        this(HouseholdCompositionResident.Pk.class, metadata, inits);
    }

    public QHouseholdCompositionResident_Pk(Class<? extends HouseholdCompositionResident.Pk> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.household = inits.isInitialized("household") ? new QHousehold(forProperty("household"), inits.get("household")) : null;
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

