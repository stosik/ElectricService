insert into roles (id, name) values
  (1, 'ROLE_USER');


insert into users (username, password, enabled) values
  ('wojtek', 'user', true);

insert into user_role (role_id, user_id) values
  (1, 1);

insert into categories (name) values
  ('tv'),
  ('audio-voice'),
  ('phone'),
  ('computer'),
  ('dvd');

insert into items (status, name, category_id) values
  ('WORKING', 'LG K5', 1),
  ('BROKEN', 'Beko 2WG5', 1),
  ('WORKING', 'IEMZ015', 2),
  ('WORKING', 'Kiano miato L2', 2),
  ('WORKING', 'MacbookPro 2015', 3);

insert into comments (message, item_id) values
  ('It s been broken during relocation.', 2),
  ('Not working screen with multple scratches on back.', 1),
  ('Not working at all.', 3),
  ('Has been dropped from 5 metres.', 1),
  ('Not working screen with multple scratches on back.', 3),
  ('Screen needs to be replaces', 2);