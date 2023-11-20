

-- table rol
create table rol (
                                 id integer not null,
                                 name varchar (100) not null,
                                 primary key (id)
);

create sequence rol_sequence as integer increment 1;

create table user_rol (
                            id integer not null,
                            active boolean not null,
                            created_at timestamp not null,
                            user_id integer,
                            rol_id integer,
                            primary key (id)
);
create sequence user_rol_sequence as integer increment 1;

alter table user_rol add constraint FK_User_Rol_Ref_Users foreign key (user_id)
    references users (id) on delete restrict on update restrict;

alter table user_rol add constraint FK_User_Rol_Ref_Rol foreign key (rol_id)
    references rol (id) on delete restrict on update restrict;