create table chats
(
    uuid varchar(255) not null,
    primary key (uuid)
);

create table coordinates
(
    uuid      varchar(255) not null,
    address   varchar(255),
    latitude  float4,
    longitude float4,
    primary key (uuid)
);

create table event_groups
(
    uuid varchar(255) not null,
    primary key (uuid)
);

create table event_types
(
    uuid             varchar(255) not null,
    event_type_name  varchar(255),
    event_types_uuid varchar(255),
    primary key (uuid)
);

create table events
(
    uuid            varchar(255) not null,
    duration_time   int8,
    end_date_time   timestamp,
    start_date_time timestamp,
    event_type_uuid varchar(255),
    primary key (uuid)
);

create table messages
(
    uuid      varchar(255) not null,
    date_time timestamp,
    text      varchar(255),
    chat_uuid varchar(255),
    usr_uuid  varchar(255),
    primary key (uuid)
);

create table places
(
    uuid             varchar(255) not null,
    description      varchar(255),
    name             varchar(255),
    coordinates_uuid varchar(255),
    primary key (uuid)
);

create table plofile_to_event_type
(
    profile_uuid    varchar(255) not null,
    event_type_uuid varchar(255) not null,
    primary key (event_type_uuid, profile_uuid)
);

create table profiles
(
    uuid varchar(255) not null,
    primary key (uuid)
);

create table review_on_events
(
    uuid        varchar(255) not null,
    description varchar(255),
    user_rate   int4,
    event_uuid  varchar(255),
    usr_uuid    varchar(255),
    primary key (uuid)
);

create table review_on_places
(
    uuid        varchar(255) not null,
    description varchar(255),
    user_rate   int4,
    place_uuid  varchar(255),
    usr_uuid    varchar(255),
    primary key (uuid)
);

create table review_on_trips
(
    uuid        varchar(255) not null,
    description varchar(255),
    user_rate   int4,
    trip_uuid   varchar(255),
    usr_uuid    varchar(255),
    primary key (uuid)
);

create table trip_to_event
(
    trip_uuid  varchar(255) not null,
    event_uuid varchar(255) not null,
    primary key (trip_uuid, event_uuid)
);

create table trips
(
    uuid                  varchar(255) not null,
    duration_time         int8,
    end_date_time         timestamp,
    start_date_time       timestamp,
    trip_length           int8,
    end_coordinate_uuid   varchar(255),
    start_coordinate_uuid varchar(255),
    primary key (uuid)
);

create table usr_chat
(
    chat_uuid varchar(255) not null,
    usr_uuid  varchar(255) not null
);

create table usr_to_chat
(
    usr_uuid  varchar(255) not null,
    chat_uuid varchar(255) not null,
    primary key (usr_uuid, chat_uuid)
);

create table usr_to_friend
(
    usr_uuid    varchar(255) not null,
    friend_uuid varchar(255) not null,
    primary key (friend_uuid, usr_uuid)
);

create table usr_to_profile
(
    usr_uuid     varchar(255) not null,
    profile_uuid varchar(255) not null,
    primary key (profile_uuid, usr_uuid)
);

create table usr_to_trip
(
    usr  varchar(255) not null,
    trip varchar(255) not null,
    primary key (trip, usr)
);

create table usrs
(
    uuid       varchar(255) not null,
    email      varchar(255),
    is_blocked boolean,
    nick_name  varchar(255) not null,
    password   varchar(255) not null,
    phone      varchar(255),
    role       varchar(255) not null,
    primary key (uuid)
);

alter table if exists event_types
    add constraint event_types_to_event_groups_fk
    foreign key (event_types_uuid) references event_groups;

alter table if exists events
    add constraint events_to_event_types_fk
    foreign key (event_type_uuid) references event_types;

alter table if exists messages
    add constraint messages_to_chats_fk
    foreign key (chat_uuid) references chats;

alter table if exists messages
    add constraint messages_to_usrs_fk
    foreign key (usr_uuid) references usrs;

alter table if exists places
    add constraint places_to_coordinates_fk
    foreign key (coordinates_uuid) references coordinates;

alter table if exists plofile_to_event_type
    add constraint plofile_to_event_type_to_event_types_fk
    foreign key (event_type_uuid) references event_types;

alter table if exists plofile_to_event_type
    add constraint plofile_to_event_type_to_profiles_fk
    foreign key (profile_uuid) references profiles;

alter table if exists review_on_events
    add constraint review_on_events_to_events_fk
    foreign key (event_uuid) references events;

alter table if exists review_on_events
    add constraint review_on_events_to_usrs_fk
    foreign key (usr_uuid) references usrs;

alter table if exists review_on_places
    add constraint review_on_places_to_places_fk
    foreign key (place_uuid) references places;

alter table if exists review_on_places
    add constraint review_on_places_to_usrs_fk
    foreign key (usr_uuid) references usrs;

alter table if exists review_on_trips
    add constraint review_on_trips_to_trips_fk
    foreign key (trip_uuid) references trips;

alter table if exists review_on_trips
    add constraint review_on_trips_to_usrs_fk
    foreign key (usr_uuid) references usrs;

alter table if exists trip_to_event
    add constraint trip_to_event_to_events_fk
    foreign key (event_uuid) references events;

alter table if exists trip_to_event
    add constraint trip_to_event_to_trips_fk
    foreign key (trip_uuid) references trips;

alter table if exists trips
    add constraint trips_to_coordinates_fk
    foreign key (end_coordinate_uuid) references coordinates;

alter table if exists trips
    add constraint trips_to_coordinates_fk
    foreign key (start_coordinate_uuid) references coordinates;

alter table if exists usr_chat
    add constraint usr_chat_to_usrs_fk
    foreign key (usr_uuid) references usrs;

alter table if exists usr_chat
    add constraint usr_chat_to_chats_fk
    foreign key (chat_uuid) references chats;

alter table if exists usr_to_chat
    add constraint usr_to_chat_to_chats_fk
    foreign key (chat_uuid) references chats;

alter table if exists usr_to_chat
    add constraint usr_to_chat_to_usrs_fk
    foreign key (usr_uuid) references usrs;

alter table if exists usr_to_friend
    add constraint usr_to_friend_to_usrs_fk
    foreign key (friend_uuid) references usrs;

alter table if exists usr_to_friend
    add constraint usr_to_friend_to_usrs_fk
    foreign key (usr_uuid) references usrs;

alter table if exists usr_to_profile
    add constraint usr_to_profile_to_profiles_fk
    foreign key (profile_uuid) references profiles;

alter table if exists usr_to_profile
    add constraint usr_to_profile_to_usrs_fk
    foreign key (usr_uuid) references usrs;

alter table if exists usr_to_trip
    add constraint usr_to_trip_to_trips_fk
    foreign key (trip) references trips;

alter table if exists usr_to_trip
    add constraint usr_to_trip_to_usrs_fk
    foreign key (usr) references usrs;