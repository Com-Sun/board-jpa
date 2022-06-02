package com.nhnacademy.resident.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBirthDeathReportResident_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QBirthDeathReportResident_Pk extends BeanPath<BirthDeathReportResident.Pk> {

    private static final long serialVersionUID = -1810835590L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBirthDeathReportResident_Pk pk = new QBirthDeathReportResident_Pk("pk");

    public final StringPath birthDeathTypeCode = createString("birthDeathTypeCode");

    public final NumberPath<Long> reportResidentSerialNumber = createNumber("reportResidentSerialNumber", Long.class);

    public final QResident resident;

    public QBirthDeathReportResident_Pk(String variable) {
        this(BirthDeathReportResident.Pk.class, forVariable(variable), INITS);
    }

    public QBirthDeathReportResident_Pk(Path<? extends BirthDeathReportResident.Pk> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBirthDeathReportResident_Pk(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBirthDeathReportResident_Pk(PathMetadata metadata, PathInits inits) {
        this(BirthDeathReportResident.Pk.class, metadata, inits);
    }

    public QBirthDeathReportResident_Pk(Class<? extends BirthDeathReportResident.Pk> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

