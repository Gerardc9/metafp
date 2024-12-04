CREATE TABLE IF NOT EXISTS restapp."reservations" (
    reservation_id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    restaurant_id UUID NOT NULL,
    number_of_guests INT NOT NULL,
    is_active BOOLEAN NOT NULL,
    FOREIGN KEY (user_id) REFERENCES restapp."users"(user_id),
    FOREIGN KEY (restaurant_id) REFERENCES  restapp."restaurants"(restaurant_id)
);
