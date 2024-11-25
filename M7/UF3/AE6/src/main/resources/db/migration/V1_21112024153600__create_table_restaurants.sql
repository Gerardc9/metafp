CREATE TABLE IF NOT EXISTS restapp."restaurants"(
  restaurant_id uuid NOT NULL,
  name VARCHAR(30) NOT NULL,
  capacity INT NOT NULL,
  foody_type VARCHAR(30) NOT NULL,
  PRIMARY KEY (restaurant_id)
);