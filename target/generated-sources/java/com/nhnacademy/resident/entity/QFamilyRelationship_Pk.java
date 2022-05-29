package com.nhnacademy.resident.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFamilyRelationship_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFamilyRelationship_Pk extends BeanPath<FamilyRelationship.Pk> {

    private static final long serialVersionUID = 139863895L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFamilyRelationship_Pk pk = new QFamilyRelationship_Pk("pk");

    public final NumberPath<Long> familyResidentSerialNumber = createNumber("familyResidentSerialNumber", Long.class);

    public final QResident resident;

    public QFamilyRelationship_Pk(String variable) {
        this(FamilyRelationship.Pk.class, forVariable(variable), INITS);
    }

    public QFamilyRelationship_Pk(Path<? extends FamilyRelationship.Pk> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFamilyRelationship_Pk(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFamilyRelationship_Pk(PathMetadata metadata, PathInits inits) {
        this(FamilyRelationship.Pk.class, metadata, inits);
    }

    public QFamilyRelationship_Pk(Class<? extends FamilyRelationship.Pk> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

