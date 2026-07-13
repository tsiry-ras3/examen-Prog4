create table "image_metadata" (
    id uuid primary key default uuid_generate_v4(),
    nom_fichier varchar not null,
    email varchar not null
);