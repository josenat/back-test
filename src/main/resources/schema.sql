create table PASG.TBASG104_EXPEDIENT (cdgo_expedient bigint not null,mrca_activo boolean,cdgo_alcanceambito integer, cdgo_alcanceot integer, cdgo_ambitos integer, cdgo_alcanauxcab integer, cdgo_empresa integer, cdgo_entorno integer, cdgo_espec integer, cdgo_linea varchar(255), cdgo_persona integer, cdgo_serie varchar(255), cdgo_sociotor varchar(255), cdgo_subserie varchar(255), cdgo_tipohab integer, fcha_act timestamp, fcha_expediente timestamp, desg_observa varchar(255), desg_aviso varchar(255), desg_observa_ext varchar(255), desg_tipoinfraestruc varchar(255), desg_usuact varchar(255), primary key (cdgo_expedient))

create table PASG.TBASG100_PERSONA (CDGO_PERSONA integer not null, DESG_NIFPAS varchar(255), DESG_MATRICULA varchar(255), DESG_NOMBRE varchar(255), DESG_APELL1 varchar(255), DESG_APELL2 varchar(255), CDGO_TIPOVIA integer, DESG_VIA varchar(255), DESG_NUMVIA varchar(255), DESG_PLANTA varchar(255), DESG_PUERTA varchar(255), DESG_ESCALERA varchar(255), DESG_MUNICIPIO varchar(255), CDGO_PROVINCIA varchar(255), CDGO_NACION integer, DESG_CODPOSTAL varchar(255), FCHA_NACIMIENTO timestamp, CDGO_CARGO varchar(255), CDGO_CENTCONT varchar(255), CDGO_AREACT integer, FCHA_CONTRATO timestamp, CDGO_ESTUDIO integer, DESG_ESTUDIEQUIV varchar(255), DESG_CERTCASTELL varchar(255), MRCA_FORMADOR boolean, DESG_USUACT varchar(255), FCHA_ACT timestamp, MRCA_ACTIVO boolean, DESC_AREA_ACT varchar(255), CDGO_TIPODOC integer, CDGO_ARETER integer, FCHA_ANTIG_CARGO timestamp, DESG_LUGARNACIMIENTO varchar(255), DIAS_ILT timestamp, DESG_EIN varchar(255), primary key (CDGO_PERSONA))


create table PASG.TBASG105_AREACTIVI (CDGO_AREACT integer, DESG_NOMBRE varchar(255), DESG_USUACT varchar(255), FCHA_ACT timestamp, MRCA_ACTIVO varchar(10), CDGO_SOCIEDAD varchar(255))

create table PASG.TBASG106_PROVINCIA (CDGO_PROVINCIA integer, DESG_NOMBRE varchar(255), DESG_USUACT varchar(255), FCHA_ACT timestamp, MRCA_ACTIVO varchar(10))

create table PASG.TBASG107_TIPOVIA (CDGO_TIPOVIA integer, CDGO_SAP varchar(255), DESG_NOMBRE varchar(255), DESG_USUACT varchar(255), FCHA_ACT timestamp, MRCA_ACTIVO varchar(10))

create table PASG.TBASG135_CARGO (CDGO_CARGO varchar(10), DESG_NOMBRE varchar(255), DESG_USUACT varchar(255), FCHA_ACT timestamp, MRCA_ACTIVO varchar(10))

create table PASG.TBASG150_TIPODOC (CDGO_TIPODOC integer, DESG_NOMBRE varchar(255), DESG_USUACT varchar(255), FCHA_ACT timestamp, MRCA_ACTIVO varchar(10))