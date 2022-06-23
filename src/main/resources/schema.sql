create table if not exists Users (
                                    id identity primary key,
                                    username varchar(50) not null,
                                    password varchar(100) not null,
                                    fullname varchar(50) not null,
                                    street varchar(50) not null,
                                    city varchar(50) not null,
                                    state varchar(50) not null,
                                    zip varchar(10) not null,
                                    phoneNumber varchar(10) not null
);
create table if not exists Taco_Order (
                                          id identity primary key,
                                          delivery_Name varchar(50) not null,
                                          delivery_Street varchar(50) not null,
                                          delivery_City varchar(50) not null,
                                          delivery_State varchar(2) not null,
                                          delivery_Zip varchar(10) not null,
                                          cc_number varchar(16) not null,
                                          cc_expiration varchar(5) not null,
                                          cc_cvv varchar(3) not null,
                                          placed_at timestamp not null
);
create table if not exists Taco (
                                    id identity primary key ,
                                    name varchar(50) not null,
                                    taco_order bigint not null,
                                    taco_order_key bigint not null,
                                    created_at timestamp not null
);
create table if not exists Ingredient_Ref (
                                              ingredient varchar(4) not null,
                                              taco bigint not null,
                                              taco_key bigint null --need to check how to insert this autoincrement value automatically using JPA
);
create table if not exists Ingredient (
                                          id varchar(4) not null primary key ,
                                          name varchar(25) not null,
                                          type varchar(10) not null
);
alter table Taco
    add foreign key (taco_order) references Taco_Order(id);
alter table Ingredient_Ref
    add foreign key (ingredient) references Ingredient(id);