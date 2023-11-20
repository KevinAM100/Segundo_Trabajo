create table users (
                            id integer not null,
                            username varchar(150) not null,
							password varchar(150) not null,
							email varchar(150) not null,
                            created_at timestamp,
                            primary key (id)
);
create sequence user_sequence as integer increment 1;

create table user_detail (
                            id integer not null,
                            first_name varchar(150) not null,
							last_name varchar(150) not null,
							age Integer,
							birth_day Date,
                            user_id bigint,
                            primary key (id)
);
create sequence user_detail_sequence as integer increment 1;

alter table user_detail add constraint FK_User_Detail_Ref_Users foreign key (user_id)
    references users (id) on delete restrict on update restrict;

