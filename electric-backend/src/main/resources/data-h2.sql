insert into categories (name) values
  ('tv'),
  ('audio-voice'),
  ('phone'),
  ('computer'),
  ('dvd');


insert into items (status, category_id) values
  ('WORKING', 1),
  ('BROKEN', 3),
  ('WORKING', 2),
  ('BROKEN', 4);

insert into messages (message, item_id) values
  ('It s been broken during relocation.', 2),
  ('Not working screen with multple scratches on back.', 1),
  ('Not working at all.', 3),
  ('Has been dropped from 5 metres.', 1),
  ('Screen needs to be replaces', 2);