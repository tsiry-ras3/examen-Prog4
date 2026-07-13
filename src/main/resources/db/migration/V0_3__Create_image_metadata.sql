create table "image_metadata" (
    id varchar primary key default uuid_generate_v4(),
    nom_fichier varchar not null,
    email varchar not null
);