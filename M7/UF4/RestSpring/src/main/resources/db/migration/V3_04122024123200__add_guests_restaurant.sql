ALTER TABLE restapp."restaurants"
ADD COLUMN IF NOT EXISTS current_guests INT NOT NULL DEFAULT 0;